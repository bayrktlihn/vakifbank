package io.bayrktlihn.vakifbank.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Bank {
    _0010("0010", "T.C.ZİRAAT BANKASI A.Ş."),
    _0032("0032", "TÜRK EKONOMİ BANKASI A.Ş."),
    _0890("0890", "FUPS"),
    _0150("0150", "Golden Global Yatırım Bankası A.Ş"),
    _0096("0096", "TURKISH BANK A.Ş."),
    _0092("0092", "CITIBANK A.Ş."),
    _0864("0864", "IYZI ODEME VE ELEKTRONIK PARA HIZMETLERI A.Ş"),
    _0205("0205", "KUVEYT TÜRK KATILIM BANKASI A.Ş."),
    _0103("0103", "FIBABANKA A.Ş."),
    _0125("0125", "BURGAN BANK A.Ş."),
    _0203("0203", "ALBARAKA TÜRK KATILIM BANKASI A.Ş."),
    _0046("0046", "AKBANK T.A.Ş."),
    _0123("0123", "HSBC BANK A.Ş."),
    _0124("0124", "ALTERNATİF BANK A.Ş."),
    _0146("0146", "ODEA BANK A.Ş."),
    _0143("0143", "AKTİF YATIRIM BANKASI A.Ş."),
    _0067("0067", "YAPI VE KREDİ BANKASI A.Ş."),
    _6006("6006", "PALADYUM ELEKTRONİK PARAVE ÖDEME HİZMETLERİ"),
    _0109("0109", "ICBC TURKEY BANK A.Ş."),
    _0209("0209", "ZİRAAT KATILIM BANKASI A.Ş."),
    _0825("0825", "BİRLEŞİK ÖDEME"),
    _0206("0206", "TÜRKİYE FİNANS KATILIM BANKASI A.Ş."),
    _0108("0108", "TURKLAND BANK A.Ş."),
    _0900("0900", "DENİZBANK A.Ş."),
    _6001("6001", "TÜRK ELEKTRONİK PARA A.Ş."),
    _6003("6003", "POSTA VE TELGRAF TEŞKİLATI A.Ş."),
    _6002("6002", "PAPARA ELEKTRONİK PARA HİZMETLERİ A.Ş"),
    _6005("6005", "TURKCELL ELEKTRONİK PARA VE ÖDEME HİZMETLERİ"),
    _6004("6004", "İNİNAL ÖDEME VE ELEKTRONİK PARA HİZMETLERİ AŞ."),
    _0064("0064", "T. İŞ BANKASI A.Ş."),
    _0062("0062", "T. GARANTİ BANKASI A.Ş."),
    _0015("0015", "T. VAKIFLAR BANKASI T.A.O."),
    _0059("0059", "ŞEKERBANK T.A.Ş."),
    _0134("0134", "DENİZBANK A.Ş."),
    _0211("0211", "Türkiye Emlak Katılım Bankası A.Ş."),
    _0135("0135", "ANADOLUBANK A.Ş."),
    _0099("0099", "ING BANK A.Ş."),
    _0012("0012", "T.HALK BANKASI A.Ş."),
    _0111("0111", "FİNANS BANK A.Ş."),
    _0210("0210", "VAKIF KATILIM BANKASI A.Ş."),
    _0870("0870", "TT Ödeme ve Elektronik Para Hizmetleri A.Ş."),
    _0839("0839", "OZAN ODEME"),
    _0838("0838", "SİPAY");

    private final String code;
    private final String name;

    Bank(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Bank parse(String bankCode) {
        return Arrays.stream(values()).filter(item -> item.getCode().equals(bankCode)).findFirst().orElseThrow(() -> new IllegalArgumentException(bankCode));
    }
}
