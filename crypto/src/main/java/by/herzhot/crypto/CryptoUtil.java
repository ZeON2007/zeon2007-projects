package by.herzhot.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

public enum CryptoUtil {

    INSTANCE;

    private static final String CIPHER_TRANSFORMATION_AES_CBC_PKCS5PADDING = "AES/CBC/PKCS5Padding";
    private static final String CHARACTER_SET = "UTF-8";
    private static final String AES_ALGORITHM_PARAMETER = "AES";

    public byte[] cipherEncrypt(final String text, final String key) throws Exception {

        int ivSize = 16;
        byte[] ivBytes = new byte[ivSize];
        SecureRandom random = new SecureRandom();
        random.nextBytes(ivBytes);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        byte[] keyBytes = key.getBytes(CHARACTER_SET);
        Key secretKeySpec = new SecretKeySpec(keyBytes, AES_ALGORITHM_PARAMETER);

        byte[] textBytes = text.getBytes(CHARACTER_SET);
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION_AES_CBC_PKCS5PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(textBytes);

        byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
        System.arraycopy(ivBytes, 0, encryptedIVAndText, 0, ivSize);
        System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);

        return encryptedIVAndText;
    }

    public byte[] cipherDecrypt(final byte[] encryptedIvTextBytes, final String key) throws Exception {

        int ivSize = 16;
        byte[] iv = new byte[ivSize];
        System.arraycopy(encryptedIvTextBytes, 0, iv, 0, iv.length);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        int encryptedSize = encryptedIvTextBytes.length - ivSize;
        byte[] encryptedBytes = new byte[encryptedSize];
        System.arraycopy(encryptedIvTextBytes, ivSize, encryptedBytes, 0, encryptedSize);

        byte[] keyBytes = key.getBytes(CHARACTER_SET);
        Key secretKeySpec = new SecretKeySpec(keyBytes, AES_ALGORITHM_PARAMETER);

        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION_AES_CBC_PKCS5PADDING);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        return cipher.doFinal(encryptedBytes);
    }

    public String base64Encrypt(final byte[] encryptedData) throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encoded = encoder.encode(encryptedData);
        return new String(encoded, CHARACTER_SET);
    }

    public byte[] base64Decrypt(final String decryptedData) {
        Base64.Decoder decoder = Base64.getDecoder();
        return decoder.decode(decryptedData);
    }

}
