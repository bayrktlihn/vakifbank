package io.bayrktlihn.vakifbank.service;

import io.bayrktlihn.vakifbank.dto.GetBinResponseDto;
import io.bayrktlihn.vakifbank.mapper.BinMapper;
import io.bayrktlihn.vakifbank.model.Bin;
import io.bayrktlihn.vakifbank.repository.BinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BinService {

    private final BinRepository binRepository;
    private final BinMapper binMapper;


    public GetBinResponseDto getBinByCardNumber(String cardNumber) {
        Bin bin = binRepository.getBinByCardNumber(cardNumber);
        return binMapper.binToGetBinResponseDto(bin);
    }


}
