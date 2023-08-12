package io.bayrktlihn.vakifbank.enums;

public enum AccountType {
    BUSINESS,
    PERSONAL;


    public static AccountType parse(String name) {
        if (name.equals("TİCARİ KART")) {
            return BUSINESS;
        } else if (name.equals("BİREYSEL KART")) {
            return PERSONAL;
        }
        throw new IllegalArgumentException(name);
    }
}
