package io.bayrktlihn.vakifbank.repository;

import io.bayrktlihn.vakifbank.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {




}
