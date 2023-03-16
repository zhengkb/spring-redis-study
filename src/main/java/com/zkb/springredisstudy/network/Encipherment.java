package com.zkb.springredisstudy.network;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encipherment {

    public static void main(String[] args) {

        String abcdefg = computeSHA1("zkbdqq.123654789.");
        System.out.println(abcdefg);
    }

    public static String computeSHA1(String message) {
        byte[] bytes = message.getBytes();
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return messageDigest.digest(bytes).toString();
    }
}
