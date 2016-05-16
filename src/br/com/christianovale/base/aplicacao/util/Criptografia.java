package br.com.christianovale.base.aplicacao.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author christiano vale
 * @version 1.0
 * 
 * <p>Description: Christiano Vale - Base Aplicação</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Christiano Vale Sistemas</p>
 * 
 * Classe que implementa o algoritmo de criptografia MD-5
 */
public class Criptografia {

    private static MessageDigest md = null;

    /**
     * Metodo estatico para a geracao do algoritmo de criptografia.
     */
    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Criptografa a senha.
     * @param pwd, String A senha normal.
     * @return String, A senha criptografaga.
     */
    public static String criptografar(String pwd) {
        if (md != null) {
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }

    /**
     * 
     * @param text
     * @return
     */
    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }
}
