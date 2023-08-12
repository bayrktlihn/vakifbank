package io.bayrktlihn.vakifbank.dto;

import io.bayrktlihn.vakifbank.enums.Currency;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

@Getter
@Setter
@AllArgsConstructor
public class PayWithThreeDSecureRequestDto {
    @NotNull
    @Builder.Default
    private Long orderNumber = null;

    @NotEmpty
    @Builder.Default
    private String cardHolderName = null;


    @Builder.Default
    @CreditCardNumber
    private String cardNumber = null;


    @Builder.Default
    @Min(1)
    @Max(12)
    private Integer expireMonth = null;


    @NotEmpty
    @Builder.Default
    private Integer expireYear = null;


    @NotEmpty
    @Builder.Default
    private String cvv = null;

    @NotNull
    private Currency currency;

    private Integer installmentCount;
}
