package io.bayrktlihn.vakifbank.enums;

import lombok.Getter;

@Getter
public enum CardSchema {
    AMEX("400"),
    UNION_PAY(null),
    PROPRIETARY_DOMESTIC(null),
    MASTERCARD("200"),
    VISA("100"),
    TROY("300");


    private final String code;

    CardSchema(String code) {
        this.code = code;
    }

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
