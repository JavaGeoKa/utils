package com.geo.crypto;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.hybrid.HybridKeyTemplates;
import com.google.crypto.tink.proto.KeyTemplate;

import java.security.GeneralSecurityException;
import java.util.Base64;

public class ChipherController {

    public static void main(String[] args) throws GeneralSecurityException {

        AeadConfig.register();
        KeysetHandle keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES256_GCM);

//        TinkConfig.register();
//        KeysetHandle keysetHandle = KeysetHandle.generateNew(HybridKeyTemplates.ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM);

        String plaintext = "I want to break free!";
        String aad = "Queen";

        Aead aead = keysetHandle.getPrimitive(Aead.class);
        byte[] ciphertext = aead.encrypt(plaintext.getBytes(), aad.getBytes());
        String encr = Base64.getEncoder().encodeToString(ciphertext);
        System.out.println(encr);

        byte[] decrypted = aead.decrypt(Base64.getDecoder().decode(encr), aad.getBytes());
        String decr = new String(decrypted);
        System.out.println(decr);


    }

}


//    public KeysetHandle getPublicKeysetHandle() throws GeneralSecurityException {
//        if (keyset == null) {
//            throw new GeneralSecurityException("cleartext keyset is not available");
//        }
//        Keyset.Builder keysetBuilder = Keyset.newBuilder();
//        for (Keyset.Key key : keyset.getKeyList()) {
//            KeyData keyData = createPublicKeyData(key.getKeyData());
//            keysetBuilder.addKey(Keyset.Key.newBuilder().mergeFrom(key).setKeyData(keyData).build());
//        }
//        keysetBuilder.setPrimaryKeyId(keyset.getPrimaryKeyId());
//        return new KeysetHandle(keysetBuilder.build());
//    }
