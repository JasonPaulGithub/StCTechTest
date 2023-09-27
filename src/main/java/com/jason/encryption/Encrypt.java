package com.jason.encryption;

import jakarta.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;

public class Encrypt implements AttributeConverter<String,String> {
    @Autowired
    EncryptionComponent encryptionComponent;

    @Override
    public String convertToDatabaseColumn(String s) {
        return encryptionComponent.encrypt(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return encryptionComponent.decrypt(s);
    }
}
