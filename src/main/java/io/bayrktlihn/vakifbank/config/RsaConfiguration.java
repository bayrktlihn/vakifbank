package io.bayrktlihn.vakifbank.config;

import io.bayrktlihn.vakifbank.util.encryption.Encryption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RsaConfiguration {


    @Bean
    Encryption rsa(RsaProperties rsaProperties) {
        String base64EncodedPrivateKey = rsaProperties.getBase64EncodedPrivateKey();
        String base64EncodedPublicKey = rsaProperties.getBase64EncodedPublicKey();
        return Encryption.createRsa(base64EncodedPrivateKey, base64EncodedPublicKey);
    }

}
