package io.bayrktlihn.vakifbank.controller;


import io.bayrktlihn.vakifbank.dto.PayWithThreeDSecureRequestDto;
import io.bayrktlihn.vakifbank.service.VakifBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class VakifBankController {

    private final VakifBankService vakifBankService;


    @PostMapping("payWithThreeDSecure")
    public Map<String, Object> payWithThreeDSecure(@RequestBody PayWithThreeDSecureRequestDto payWithThreeDSecureRequestDto) {
        return vakifBankService.payWithThreeDSecure(payWithThreeDSecureRequestDto);
    }


}
