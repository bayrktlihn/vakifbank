package io.bayrktlihn.vakifbank.client.vakifbank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckEnrollmentParamDto {

    @Builder.Default
    private String merchantId = null;
    @Builder.Default
    private String merchantPassword = null;
    @Builder.Default
    private String verifyEnrollmentRequestId = null;
    @Builder.Default
    private String pan = null;
    @Builder.Default
    private String exprityDate = null;
    @Builder.Default
    private String purchaseAmount = null;
    @Builder.Default
    private String currency = null;
    @Builder.Default
    private String brandName = null;
    @Builder.Default
    private String successUrl = null;
    @Builder.Default
    private String failureUrl = null;
    @Builder.Default
    private String fullName = null;
    @Builder.Default
    private String cvv = null;
    @Builder.Default
    private String clientIpAddress = null;

}
