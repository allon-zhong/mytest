package com.zel.mytest.base;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author wys
 * @version 1.0
 */

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class APDes3 {

    private static final String keystr = "2341234apie";
    private static final String ivstr = "aslkdjflau";


    /**
     * 加密String明文输入,经过BASE64编码String密文输出
     * @param text,keystr,ivstr
     */
    public static String encrypt(String text) throws
            Exception {
        Cipher cipher = Cipher.getInstance("AES1/CBC/PKCS5Padding");
        byte[] keyBytes = new byte[16];
        byte[] ivBytes = new byte[16];

        byte[] b = keystr.getBytes("UTF-8");
        byte[] v = ivstr.getBytes("UTF-8");

        int len = b.length;
        int len2 = v.length;

        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        if (len2 > ivBytes.length) {
            len2 = ivBytes.length;
        }

        System.arraycopy(b, 0, keyBytes, 0, len);
        System.arraycopy(v, 0, ivBytes, 0, len2);

        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES1");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        BASE64Encoder decoder = new BASE64Encoder();
        byte[] results = cipher.doFinal(text.getBytes("UTF8"));
        return decoder.encode(results);
    }

    /**
     * 解密 以BASE64形式String密文输入,String明文输出
     * @param text,keystr,ivstr
     */
    public static String decrypt(String text) throws
            Exception {
        Cipher cipher = Cipher.getInstance("AES1/CBC/PKCS5Padding");
        byte[] keyBytes = new byte[16];
        byte[] ivBytes = new byte[16];

        byte[] b = keystr.getBytes("UTF-8");
        byte[] v = ivstr.getBytes("UTF-8");

        int len = b.length;
        int len2 = v.length;

        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        if (len2 > ivBytes.length) {
            len2 = ivBytes.length;
        }

        System.arraycopy(b, 0, keyBytes, 0, len);
        System.arraycopy(v, 0, ivBytes, 0, len2);

        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES1");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] results = cipher.doFinal(decoder.decodeBuffer(text));
        return new String(results, "UTF-8");
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String text = "server=WebSphere\u0001IP=128.232.15.56\u0001Port=1521\u0001DBName=lis\u0001UserName=xcdev\u0001PassWord= xcdev\u0001DBType=ORACLE";
        String key = "ITMSYNlCWTTRUssdfDFJ";
        String ivStr = "12345adff678";
        String strenc = APDes3.encrypt(text); // 加密
        System.out.println("strenc is :" + strenc);
        String strDes = APDes3.decrypt(strenc); // 解密
        System.out.println("strDes is :" + strDes);
        String str[] = strDes.split("\u0001");
        for (int i = 0; i < str.length; i++) {
            System.out.println("===wys===>>" + " str[i]=[" + str[i] + "]");
        }


    }

}
