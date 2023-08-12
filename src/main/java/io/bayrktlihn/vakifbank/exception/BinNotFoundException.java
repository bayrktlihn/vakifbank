package io.bayrktlihn.vakifbank.exception;

public class BinNotFoundException extends RuntimeException {
    public BinNotFoundException(String cardNumber) {
        super(cardNumber);
    }
}
