package io.bayrktlihn.vakifbank.mapper;


import io.bayrktlihn.vakifbank.dto.BinDto;
import io.bayrktlihn.vakifbank.dto.GetBinResponseDto;
import io.bayrktlihn.vakifbank.model.Bin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BinMapper {

    BinDto binToBinDto(Bin bin);

    @Mapping(target = "bankCode", source = "bank.code")
    GetBinResponseDto binToGetBinResponseDto(Bin bin);

}
