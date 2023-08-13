package io.bayrktlihn.vakifbank.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("bayrktlihn.rsa")
@Setter
@Getter
public class RsaProperties {

    private String base64EncodedPublicKey;
    private String base64EncodedPrivateKey;

}
