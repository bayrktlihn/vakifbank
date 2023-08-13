package io.bayrktlihn.vakifbank.entity;


import io.bayrktlihn.vakifbank.enums.Currency;
import io.bayrktlihn.vakifbank.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
@SuperBuilder
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderNumber;

    private BigDecimal totalAmount;

    @Builder.Default
    private PaymentStatus paymentStatus = PaymentStatus.NOT_PAID;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Integer installmentCount;


}
