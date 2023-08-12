package io.bayrktlihn.vakifbank.repository;

import io.bayrktlihn.vakifbank.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderNumber(Long orderNumber);

    @Query("select o from Order o join fetch o.orderDetails")
    Order findOrderWithDetailsByOrderNumber(Long orderNumber);
}
