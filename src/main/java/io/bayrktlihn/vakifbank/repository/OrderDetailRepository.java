package io.bayrktlihn.vakifbank.repository;

import io.bayrktlihn.vakifbank.entity.Order;
import io.bayrktlihn.vakifbank.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findByOrder(Order order);

}
