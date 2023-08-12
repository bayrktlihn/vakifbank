package io.bayrktlihn.vakifbank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

@Getter
@Setter
@NoArgsConstructor
public class GetBinRequestDto {

    @CreditCardNumber
    private String cardNumber;
}
