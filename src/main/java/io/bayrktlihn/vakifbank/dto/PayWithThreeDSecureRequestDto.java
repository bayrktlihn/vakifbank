package io.bayrktlihn.vakifbank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PayWithThreeDSecureRequestDto {
    @Builder.Default
    private Long orderNumber = null;
    @Builder.Default
    private String cardHolderName = null;
    @Builder.Default
    private String cardNumber = null;
    @Builder.Default
    private Integer expireMonth = null;
    @Builder.Default
    private Integer expireYear = null;
    @Builder.Default
    private String cvv = null;
}
