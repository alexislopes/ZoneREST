package com.example.demo.rules;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encript {

    public static String criptografar(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }

    public static Boolean comparar(String senha, String hash) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Boolean flag = false;

        String criptografada = criptografar(senha);
        if(criptografada.equals(hash)){
            flag = true;
        }

        return flag;
    }
}
