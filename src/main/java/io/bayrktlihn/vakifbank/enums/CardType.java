package io.bayrktlihn.vakifbank.enums;

public enum CardType {
    CREDIT_CARD,
    PREPAID_KART,
    DEBIT_CARD;


    public static CardType parse(String name) {
        if (name.equals("KREDİ KARTI")) {
            return CREDIT_CARD;
        } else if (name.equals("PREPAİD KART")) {
            return PREPAID_KART;
        } else if (name.equals("DEBİT KART")) {
            return DEBIT_CARD;
        }
        throw new IllegalArgumentException(name);
    }
}
