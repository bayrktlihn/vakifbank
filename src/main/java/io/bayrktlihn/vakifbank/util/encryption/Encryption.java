package io.bayrktlihn.vakifbank.util.encryption;

import io.bayrktlihn.vakifbank.util.encryption.impl.Aes;
import io.bayrktlihn.vakifbank.util.encryption.impl.Rsa;

public interface Encryption {

    String encrypt(String plainText);

    String decrypt(String base64Encrypted);

    static Encryption createAes(String encodedBase64Key) {
        return new Aes(encodedBase64Key);
    }

    static Encryption createRsa(String base64EncodedPrivateKey, String base64EncodedPublicKey) {
        return new Rsa(base64EncodedPrivateKey, base64EncodedPublicKey);
    }


}