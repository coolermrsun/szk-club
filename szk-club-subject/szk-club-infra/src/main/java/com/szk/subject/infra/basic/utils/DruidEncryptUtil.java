package com.szk.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class DruidEncryptUtil {
    private static String publicKey;

    private static String privateKey;

    static {
        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            privateKey = keyPair[0];
            System.out.println("privateKey:" + privateKey);
            publicKey = keyPair[1];
            System.out.println("publicKey:" + publicKey);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }
    public static String encrypt(String plainText) throws Exception{
        String encrypt = ConfigTools.encrypt(privateKey,plainText);
        System.out.println("encrypt:" + encrypt);
        return encrypt;
    }

    public static String decrypt(String encryptText) throws Exception{
        String decrypt = ConfigTools.decrypt(privateKey,encryptText);
        System.out.println("decrypt:" + decrypt);
        return decrypt;
    }

    public static void main(String[] args) throws Exception {
        String encrypt = encrypt("Wing1Q2W#E");
        System.out.println("encrypt:" + encrypt);
    }
}
