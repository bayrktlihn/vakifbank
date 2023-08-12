package io.bayrktlihn.vakifbank.service;

import io.bayrktlihn.vakifbank.client.vakifbank.VakifBankClient;
import io.bayrktlihn.vakifbank.client.vakifbank.dto.CheckEnrollmentParamDto;
import io.bayrktlihn.vakifbank.client.vakifbank.dto.IPaySecureDto;
import io.bayrktlihn.vakifbank.client.vakifbank.dto.VEResDto;
import io.bayrktlihn.vakifbank.dto.PayWithThreeDSecureRequestDto;
import io.bayrktlihn.vakifbank.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VakifBankService {

    private final VakifBankClient vakifBankClient;
    private final OrderService orderService;
    private final PaymentService paymentService;


    public Map<String, Object> payWithThreeDSecure(PayWithThreeDSecureRequestDto payWithThreeDSecureRequestDto) {
        Payment payment = paymentService.createPayment(payWithThreeDSecureRequestDto);

        Map<String, Object> checkEnrollmentResult = checkEnrollment(payWithThreeDSecureRequestDto, payment);

        return checkEnrollmentResult;
    }

    private Map<String, Object> checkEnrollment(PayWithThreeDSecureRequestDto payWithThreeDSecureRequestDto, Payment payment) {
        CheckEnrollmentParamDto checkEnrollmentParam = CheckEnrollmentParamDto.builder()
                .cvv(payWithThreeDSecureRequestDto.getCvv())
                .pan(payWithThreeDSecureRequestDto.getCardNumber())
                .purchaseAmount(payment.getTotalAmount().setScale(2, RoundingMode.HALF_UP).toString())
                .build();


        IPaySecureDto iPaySecureDto = vakifBankClient.checkEnrollment(checkEnrollmentParam);

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
}
