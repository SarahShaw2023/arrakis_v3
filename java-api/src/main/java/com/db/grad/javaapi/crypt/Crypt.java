package com.db.grad.javaapi.crypt;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//Source: https://medium.com/@jpatwa/java-encryption-javascript-decryption-using-aes-algorithm-4037ce09a2d3
public class Crypt {
    private static final String ALGO = "AES"; // Default uses ECB PKCS5Padding

    private static final String secretKey = "DB2023Hackathon!"; //"mustbe16byteskey"

    //The safe way to pass a consistent key to make/undo an encryption
    //(Use this for the "String secret" params)
    private static final String encodedBase64Key = encodeKey(secretKey);

    // Share ONLY between server (encryption) and client (decryption)

    public static void printEncodedKey() {
        System.out.println("encodedBase64Key = " + encodedBase64Key);
    }

    //Debug purposes only
    //Should match secretKey
    public static void printDecodedKey() {
        String toDecodeBase64Key = decodeKey(encodedBase64Key);
        System.out.println("toDecodeBase64Key = " + toDecodeBase64Key);
        System.out.println("secretKey = " + secretKey);
    }

    private static Key generateKey(String secret) throws Exception {
        byte[] decoded = Base64.getDecoder().decode(secret.getBytes());
        Key key = new SecretKeySpec(decoded, ALGO);
        return key;
    }

    public static String decodeKey(String str) {
        byte[] decoded = Base64.getDecoder().decode(str.getBytes());
        return new String(decoded);
    }

    public static String encodeKey(String str) {
        byte[] encoded = Base64.getEncoder().encode(str.getBytes());
        return new String(encoded);
    }
    public static String encrypt(String Data, String secret) {
        try {
            Key key = generateKey(secret);
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.ENCRYPT_MODE, key);

            byte[] encVal = c.doFinal(Data.getBytes());
            String encryptedValue = Base64.getEncoder().encodeToString(encVal);

            return encryptedValue;

        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());

            return "";
        }
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            Key key = generateKey(secret);
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.DECRYPT_MODE, key);

            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }

        return null;
    }

    public void demoCrypt() {
        String secretKey = "mustbe16byteskey";
        String encodedBase64Key = encodeKey(secretKey);
        System.out.println("EncodedBase64Key = " + encodedBase64Key); // This need to be share between client and server

        // To check actual key from encoded base 64 secretKey
        // String toDecodeBase64Key = decodeKey(encodedBase64Key);
        // System.out.println("toDecodeBase64Key = "+toDecodeBase64Key);

        String toEncrypt = "Please encrypt this message!";
        System.out.println("Plain text = " + toEncrypt);

        // AES Encryption based on above secretKey
        String encrStr = Crypt.encrypt(toEncrypt, encodedBase64Key);
        System.out.println("Cipher Text: Encryption of str = " + encrStr);

        // AES Decryption based on above secretKey
        String decrStr = Crypt.decrypt(encrStr, encodedBase64Key);
        System.out.println("Decryption of str = " + decrStr);
    }

    //Showcases a use case example
    public static void main(String[] args) {
        //demoCrypt();

        Crypt.printEncodedKey();
        Crypt.printDecodedKey();

        String txt = Crypt.encrypt("Hello world!", Crypt.encodedBase64Key);
        System.out.println("Encrypted text: " + txt);

        txt = Crypt.decrypt(txt, Crypt.encodedBase64Key);
        System.out.println("Dencrypted text: " + txt);

    }

}
