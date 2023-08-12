package io.bayrktlihn.vakifbank.service;

import io.bayrktlihn.vakifbank.entity.Order;
import io.bayrktlihn.vakifbank.entity.OrderDetail;
import io.bayrktlihn.vakifbank.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailService {


    private OrderDetailRepository orderDetailRepository;


    public List<OrderDetail> findByOrder(Order order) {
        return orderDetailRepository.findByOrder(order);
    }

}
