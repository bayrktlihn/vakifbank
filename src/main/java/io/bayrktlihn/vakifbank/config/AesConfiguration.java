package io.bayrktlihn.vakifbank.config;

import io.bayrktlihn.vakifbank.util.encryption.Encryption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AesConfiguration {


    @Bean
    public Encryption aes(AesProperties aesProperties) {
        return Encryption.createAes(aesProperties.getKey());
    }

}
