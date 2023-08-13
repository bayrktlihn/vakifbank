package io.bayrktlihn.vakifbank.converter;

import io.bayrktlihn.vakifbank.util.encryption.Encryption;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AesConverter implements AttributeConverter<String, String> {


    private final Encryption aes;

    public AesConverter(Encryption encryption) {
        this.aes = encryption;
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return aes.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return aes.decrypt(dbData);
    }

}
