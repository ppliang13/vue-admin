package com.ppl.sqltrans.service;

import java.security.MessageDigest;
import java.util.Base64;

public class SaltEncryptionExample {
    private static final String SALT = "postgres_sqlsalt";

    public static String encryptSql(String password) {
        try {
            String saltedPassword = password + SALT;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] digest = messageDigest.digest(saltedPassword.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(digest);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    public static void main(String[] args) {
        // 加密密码
        String password = "mypassword";
        String encryptedPassword = encryptSql(password);

        // 在SQL语句中使用加密后的密码进行查询
        String sql = "SELECT * FROM users WHERE password = '" + encryptedPassword + "'";
        System.out.println(sql);
    }
}