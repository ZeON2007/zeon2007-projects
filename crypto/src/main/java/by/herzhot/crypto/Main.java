package by.herzhot.crypto;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        String key = "nuaqBC9MoJlxHiM8";
        String text = "debtorIdentification=test";

        Map<String, String> params = new HashMap<>();
        params.put("qwerty", "12345");
        params.put("asdfg", "569");
        params.put("zxcvb", "erty");


        System.out.println(Arrays.toString(key.getBytes()));


        CryptoUtil crypter = CryptoUtil.INSTANCE;
        byte[] enc = crypter.cipherEncrypt(text, key);
        String encUrlString = crypter.base64Encrypt(enc);

        System.out.println(encUrlString);

        byte[] decUrl = crypter.base64Decrypt(encUrlString);
        byte[] dec = crypter.cipherDecrypt(decUrl, key);

        System.out.println(new String(dec, "UTF-8"));

        Charset charset = Charset.forName("UTF-8");
        System.out.println(charset.aliases());
        ByteBuffer buffer = charset.encode(key);
        System.out.println(buffer);
        System.out.println(Arrays.toString(buffer.array()));


    }


}
