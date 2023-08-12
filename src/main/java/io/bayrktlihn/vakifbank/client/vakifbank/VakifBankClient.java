package io.bayrktlihn.vakifbank.client.vakifbank;

import io.bayrktlihn.vakifbank.client.vakifbank.dto.CheckEnrollmentParamDto;
import io.bayrktlihn.vakifbank.client.vakifbank.dto.IPaySecureDto;
import io.bayrktlihn.vakifbank.config.VakifBankProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class VakifBankClient {

    private final VakifBankProperties vakifBankProperties;


    public IPaySecureDto checkEnrollment(CheckEnrollmentParamDto param) {

        HttpEntity<LinkedMultiValueMap<String, String>> headerAndBody = prepareHeaderAndBodyForCheckEnrollment(param);

        RestTemplate restTemplate = createRestTemplate(70000, 7000);


        try {
            ResponseEntity<IPaySecureDto> response = restTemplate.exchange(vakifBankProperties.getEnrollmentAddress(), HttpMethod.POST, headerAndBody, IPaySecureDto.class);
            return response.getBody();
        } catch (HttpClientErrorException httpClientErrorException) {
            // 400
        } catch (HttpServerErrorException httpServerErrorException) {
            // 500
        } catch (ResourceAccessException resourceAccessException){
            // ConnectException SocketTimeoutException
        }
        throw new RuntimeException();
    }

    private static HttpEntity<LinkedMultiValueMap<String, String>> prepareHeaderAndBodyForCheckEnrollment(CheckEnrollmentParamDto param) {
        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("MerchantId", param.getMerchantId());
        map.add("MerchantPassword", param.getMerchantPassword());
        map.add("VerifyEnrollmentRequestId", param.getVerifyEnrollmentRequestId());
        map.add("Pan", param.getPan());
        map.add("ExpiryDate", param.getExprityDate());
        map.add("PurchaseAmount", param.getPurchaseAmount());
        map.add("Currency", param.getCurrency());
        map.add("BrandName", param.getBrandName());
        map.add("SuccessUrl", param.getSuccessUrl());
        map.add("FailureUrl", param.getFailureUrl());
        if (param.getInstallmentCount() != null && !param.getInstallmentCount().equals(Integer.valueOf("1")) && !param.getInstallmentCount().equals(Integer.valueOf("0"))) {
            map.add("InstallmentCount", param.getInstallmentCount().toString());
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_XML_VALUE);
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return new HttpEntity<>(map, httpHeaders);
    }


    private RestTemplate createRestTemplate(int connectTimeout, int readTimeout) {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(connectTimeout);
        simpleClientHttpRequestFactory.setReadTimeout(readTimeout);
        return new RestTemplate(simpleClientHttpRequestFactory);
    }


}
