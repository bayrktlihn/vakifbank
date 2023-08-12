package io.bayrktlihn.vakifbank.enums;

import lombok.Getter;

@Getter
public enum CardSchema {
    AMEX,
    UNION_PAY,
    PROPRIETARY_DOMESTIC,
    MASTERCARD,
    VISA,
    TROY;


    public static CardSchema parse(String name) {
        if (name.equals("AMEX")) {
            return AMEX;
        } else if (name.equals("UNION PAY")) {
            return UNION_PAY;
        } else if (name.equals("Proprietary Domestic")) {
            return PROPRIETARY_DOMESTIC;
        } else if (name.equals("VISA")) {
            return VISA;
        } else if (name.equals("TROY")) {
            return TROY;
        } else if (name.equals("MASTERCARD")) {
            return MASTERCARD;
        }
        throw new IllegalArgumentException(name);
    }


}
