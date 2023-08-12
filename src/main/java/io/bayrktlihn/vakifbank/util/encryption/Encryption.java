package io.bayrktlihn.vakifbank.util.encryption;

import io.bayrktlihn.vakifbank.util.encryption.impl.Aes;

public interface Encryption {

    String encrypt(String plainText);

    String decrypt(String base64EncryptedKey);

    static Encryption createAes(String encodedBase64Key) {
        return new Aes(encodedBase64Key);
    }


}