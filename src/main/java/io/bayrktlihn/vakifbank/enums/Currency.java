package io.bayrktlihn.vakifbank.enums;

import lombok.Getter;

@Getter
public enum Currency {
    TRY("949"),
    USD("840"),
    EUR("978"),
    GBP("826");

    private final String code;

    Currency(String code) {
        this.code = code;
    }
}
