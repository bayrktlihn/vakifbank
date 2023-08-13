package io.bayrktlihn.vakifbank;

import io.bayrktlihn.vakifbank.util.encryption.Encryption;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VakifbankApplication {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(VakifbankApplication.class, args);
        Encryption aes = context.getBean("aes", Encryption.class);
    }

}
