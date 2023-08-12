package io.bayrktlihn.vakifbank.service;

import io.bayrktlihn.vakifbank.dto.PayWithThreeDSecureRequestDto;
import io.bayrktlihn.vakifbank.entity.Order;
import io.bayrktlihn.vakifbank.entity.OrderDetail;
import io.bayrktlihn.vakifbank.entity.Payment;
import io.bayrktlihn.vakifbank.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final OrderDetailService orderDetailService;
    private final OrderService orderService;
    private final PaymentRepository paymentRepository;


    @Transactional
    public Payment createPayment(PayWithThreeDSecureRequestDto payWithThreeDSecureRequestDto) {
        Long orderNumber = payWithThreeDSecureRequestDto.getOrderNumber();
        Order order = orderService.findByOrderNumber(orderNumber);
        Payment payment = createPayment(payWithThreeDSecureRequestDto, order);
        return paymentRepository.save(payment);
    }

    private Payment createPayment(PayWithThreeDSecureRequestDto payWithThreeDSecureRequestDto, Order order) {

        List<OrderDetail> orderDetails = orderDetailService.findByOrder(order);

        BigDecimal totalAmount = calculateTotalAmount(orderDetails);

        return Payment.builder()
                .installmentCount(payWithThreeDSecureRequestDto.getInstallmentCount())
                .currency(order.getCurrency())
                .orderNumber(order.getOrderNumber())
                .totalAmount(totalAmount)
                .build();
    }

    private BigDecimal calculateTotalAmount(List<OrderDetail> orderDetails) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (OrderDetail orderDetail : orderDetails) {
            totalAmount = totalAmount.add(orderDetail.getQuantity().multiply(orderDetail.getQuantity()));
        }
        return totalAmount;
    }


}
