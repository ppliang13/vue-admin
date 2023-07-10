package com.ppl.sqltrans.pojo.salt;

import cn.hutool.core.util.StrUtil;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptionSelectSql {
    /**
     * key 为16位
     */
    private static final String KEY = "POSTGRES-SQLsALT";

    /**
     * 加密
     * @param data 待加密的数据
     * @return 加密后的数据
     */
    public static String encrypt(String data) {
        if(StrUtil.isBlank(data)||data.length()<3){
            return data;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密
     * @param encryptedData 待解密的数据
     * @return 解密后的数据
     */
    public static String decrypt(String encryptedData) {
        if(StrUtil.isBlank(encryptedData)||encryptedData.length()<3){
            return encryptedData;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedData, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
