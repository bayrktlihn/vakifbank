package io.bayrktlihn.vakifbank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetBinRequestDto {
    private String cardNumber;
}
