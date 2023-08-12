package io.bayrktlihn.vakifbank.dto;

import io.bayrktlihn.vakifbank.enums.AccountType;
import io.bayrktlihn.vakifbank.enums.Bank;
import io.bayrktlihn.vakifbank.enums.CardSchema;
import io.bayrktlihn.vakifbank.enums.CardType;
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
public class BinDto {
    @Builder.Default
    private Bank bank = null;
    @Builder.Default
    private String startOfBin = null;
    @Builder.Default
    private String endOfBin = null;
    @Builder.Default
    private CardSchema cardSchema = null;
    @Builder.Default
    private CardType cardType = null;
    @Builder.Default
    private AccountType accountType = null;
    @Builder.Default
    private Integer cardNumberLength = null;
}
