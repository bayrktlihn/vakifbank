package io.bayrktlihn.vakifbank.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aes")
@Getter
@Setter
public class AesProperties {

    private String base64EncodedKey;

}
