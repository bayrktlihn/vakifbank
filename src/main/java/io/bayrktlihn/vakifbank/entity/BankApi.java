package io.bayrktlihn.vakifbank.entity;

import io.bayrktlihn.vakifbank.converter.RsaConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "bank_api")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class BankApi extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String merchantId;


    @Convert(converter = RsaConverter.class)
    @Column(length = 1000)
    private String merchantPassword;

}
