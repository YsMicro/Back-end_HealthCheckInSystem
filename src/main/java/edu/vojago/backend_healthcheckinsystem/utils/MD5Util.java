package edu.vojago.backend_healthcheckinsystem.utils;

import java.security.MessageDigest;

public class MD5Util {
    public static String encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("MD5加密失败");
        }
    }

//    public static void main(String[] args) {
//        String original = "hello123";
//        String encrypted = encrypt(original);
//        System.out.println("MD5哈希值: " + encrypted);
//        // 输出: 958aac5b7e742d317c15db086b0890cb
//    }
}
