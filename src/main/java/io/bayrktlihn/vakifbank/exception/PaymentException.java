package io.bayrktlihn.vakifbank.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentException extends RuntimeException {
    public static final String NOT_SUPPORTED_THREE_D_ERROR_CODE = "001000000";
    public static final String NOT_SUPPORTED_HAL_SECURE_PAYMENT_ERROR_CODE = "001000001";
    public static final String NOT_SUPPORTED_NON_SECURE_PAYMENT = "001000002";

    private final String message;
    private final String code;

    public static PaymentException create(String message, String code) {
        return new PaymentException(message, code);
    }


    public static PaymentException createNotSupportedThreeD() {
        return new PaymentException("Not supported three d", NOT_SUPPORTED_THREE_D_ERROR_CODE);
    }

    public static PaymentException createNotSupportedHalfSecurePayment() {
        return new PaymentException("Not supported half secure payment", NOT_SUPPORTED_HAL_SECURE_PAYMENT_ERROR_CODE);
    }

    public static PaymentException createNotSupportedNonSecurePayment() {
        return new PaymentException("Not supported non secure payment", NOT_SUPPORTED_NON_SECURE_PAYMENT);
    }
}
