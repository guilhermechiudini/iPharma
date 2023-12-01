package com.example.farmaciamobile.view.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static String encriptar(String texto, String algoritmo) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // Resumo Hash
        MessageDigest message = MessageDigest.getInstance(algoritmo);
        byte messageDigest[] = message.digest(texto.getBytes("UTF-8"));

        // Colocar no formato hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaHex = hexString.toString();
        return senhaHex;
    }

}
