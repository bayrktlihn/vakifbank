package io.bayrktlihn.vakifbank.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "vakifbank")
@Getter
@Setter
public class VakifBankProperties {
    private String enrollmentAddress;
}
