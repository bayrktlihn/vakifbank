package io.bayrktlihn.vakifbank.converter;

import io.bayrktlihn.vakifbank.util.encryption.Encryption;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class RsaConverter implements AttributeConverter<String, String> {

    private final Encryption rsa;

    public RsaConverter(Encryption rsa) {
        this.rsa = rsa;
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return rsa.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return rsa.decrypt(dbData);
    }
}
