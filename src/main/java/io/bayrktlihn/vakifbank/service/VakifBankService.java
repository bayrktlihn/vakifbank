package io.bayrktlihn.vakifbank.service;

import io.bayrktlihn.vakifbank.client.vakifbank.VakifBankClient;
import io.bayrktlihn.vakifbank.client.vakifbank.dto.CheckEnrollmentParamDto;
import io.bayrktlihn.vakifbank.client.vakifbank.dto.IPaySecureDto;
import io.bayrktlihn.vakifbank.client.vakifbank.dto.VEResDto;
import io.bayrktlihn.vakifbank.dto.GetBinResponseDto;
import io.bayrktlihn.vakifbank.dto.PayWithThreeDSecureRequestDto;
import io.bayrktlihn.vakifbank.entity.Payment;
import io.bayrktlihn.vakifbank.exception.PaymentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VakifBankService {

    private final VakifBankClient vakifBankClient;
    private final OrderService orderService;
    private final PaymentService paymentService;
    private final BinService binService;


    @Transactional
    public Map<String, Object> payWithThreeDSecure(PayWithThreeDSecureRequestDto payWithThreeDSecureRequestDto) {
        Payment payment = paymentService.createPayment(payWithThreeDSecureRequestDto);

        Map<String, Object> checkEnrollmentResult = checkEnrollment(payWithThreeDSecureRequestDto, payment);

        return checkEnrollmentResult;
    }

    private Map<String, Object> checkEnrollment(PayWithThreeDSecureRequestDto payWithThreeDSecureRequestDto, Payment payment) {

        GetBinResponseDto bin = binService.getBinByCardNumber(payWithThreeDSecureRequestDto.getCardNumber());

        String expiryDate = prepareExpiryDate(payWithThreeDSecureRequestDto);

        CheckEnrollmentParamDto checkEnrollmentParam = CheckEnrollmentParamDto.builder()
//                .merchantId()
//                .merchantPassword()
//                .verifyEnrollmentRequestId()
//                .successUrl()
//                .failureUrl()
                .cvv(payWithThreeDSecureRequestDto.getCvv())
                .pan(payWithThreeDSecureRequestDto.getCardNumber())
                .brandName(bin.getCardSchema().getCode())
                .currency(payment.getCurrency().getCode())
                .installmentCount(payment.getInstallmentCount())
                .exprityDate(expiryDate)
                .purchaseAmount(payment.getTotalAmount().setScale(2, RoundingMode.HALF_UP).toString())
                .build();


        IPaySecureDto iPaySecureDto = vakifBankClient.checkEnrollment(checkEnrollmentParam);
        checkEnrollmentResult(iPaySecureDto);

        VEResDto veRes = iPaySecureDto.getMessage().getVeRes();

        Map<String, Object> result = new HashMap<>();

        Map<String, String> formInputValues = new HashMap<>();
        formInputValues.put("md", veRes.getMd());
        formInputValues.put("termUrl", veRes.getTermUrl());
        formInputValues.put("paReq", veRes.getPaReq());

        result.put("actionUrl", veRes.getAcsUrl());
        result.put("formInputValues", formInputValues);

        return result;
    }

    private void checkEnrollmentResult(IPaySecureDto iPaySecureDto) {
        String status = iPaySecureDto.getVeRes().getStatus();
        if (status.equals("Y") && iPaySecureDto.getErrorMessage().equals("200")) {
            return;
        }

        if (status.equals("A")) {
            throw PaymentException.createNotSupportedHalfSecurePayment();
        }

        if (status.equals("U")) {
            throw PaymentException.createNotSupportedNonSecurePayment();
        }

        if (status.equals("N")) {
            throw PaymentException.createNotSupportedThreeD();
        }

        if (status.equals("E")) {
            String errorCode = iPaySecureDto.getResultDetail().getErrorCode();
            String errorMessage = iPaySecureDto.getResultDetail().getErrorMessage();
            String fixedErrorCode = String.format("009%06d", Integer.parseInt(errorCode));
            throw PaymentException.create(fixedErrorCode, errorMessage);
        }


    }

    private static String prepareExpiryDate(PayWithThreeDSecureRequestDto payWithThreeDSecureRequestDto) {
        return String.format("%02d%02d", payWithThreeDSecureRequestDto.getExpireYear(), payWithThreeDSecureRequestDto.getExpireMonth());
    }
}
