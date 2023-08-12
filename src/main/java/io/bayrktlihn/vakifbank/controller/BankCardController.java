package io.bayrktlihn.vakifbank.controller;

import io.bayrktlihn.vakifbank.dto.GetBinRequestDto;
import io.bayrktlihn.vakifbank.dto.GetBinResponseDto;
import io.bayrktlihn.vakifbank.service.BinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bank-card")
@RequiredArgsConstructor
public class BankCardController {

    private final BinService binService;


    @PostMapping("bin")
    public GetBinResponseDto getBin(@RequestBody GetBinRequestDto getBinRequestDto) {
        return binService.getBinByCardNumber(getBinRequestDto.getCardNumber());
    }
}
