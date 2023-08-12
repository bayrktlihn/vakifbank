package io.bayrktlihn.vakifbank.service;

import io.bayrktlihn.vakifbank.entity.Order;
import io.bayrktlihn.vakifbank.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public Order findByOrderNumber(Long orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber).orElseThrow(() -> new RuntimeException());
    }

    public Order findOrderWithDetailsByOrderNumber(Long orderNumber) {
        return orderRepository.findOrderWithDetailsByOrderNumber(orderNumber);
    }


}
