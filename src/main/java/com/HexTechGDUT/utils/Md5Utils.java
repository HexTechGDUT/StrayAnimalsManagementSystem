package com.HexTechGDUT.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * 用于字符串的md5加密
 * 该类仍在完善中
 * 目前暂时没有对任何对象加密
 * @author HexTechGDUT
 */
public class Md5Utils {

    private static final String HEX_NUMS_STR = "0123456789ABCDEF" ;
    private static final Integer SALT_LENGTH = 12;

    /**
     * 将 16 进制字符串转换成字节数组
     * @param hex String
     * @return byte[]
     */
    private static byte[] hexStringToByte (String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] hexChars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4 | HEX_NUMS_STR
                    .indexOf(hexChars[pos + 1]));
        }
        return result;
    }

    /**
     * 将指定 byte 数组转换成 16 进制字符串
     * @param  b byte[]
     * @return String
     */
    private static String byteToHexString(byte[] b) {
        StringBuilder hexString = new StringBuilder();
        for (byte value : b) {
            String hex = Integer.toHexString(value & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toUpperCase());
        }
        return hexString.toString();
    }

    /**
     * md5加密
     * @param s 明文
     * @return 16进制的密文
     */
    public static String encrypt(String s){
        // 声明加密后的口令数组变量
        byte[] pwd;
        // 随机数生成器
        SecureRandom random = new SecureRandom();
        try {
            // 声明盐数组变量
            byte[] salt = new byte[SALT_LENGTH];
            // 将随机数放入盐变量中
            random.nextBytes(salt);
            // 声明消息摘要对象
            MessageDigest md;
            // 创建消息摘要
            md = MessageDigest.getInstance("MD5");
            // 将盐数据传入消息摘要对象
            md.update(salt);
            // 将口令的数据传给消息摘要对象
            md.update(s.getBytes(StandardCharsets.UTF_8));
            // 获得消息摘要的字节数组
            byte[] digest = md.digest();
            // 因为要在口令的字节数组中存放盐，所以加上盐的字节长度
            pwd = new byte[digest.length + SALT_LENGTH];
            // 将盐的字节拷贝到生成的加密口令字节数组的前 12 个字节，以便在验证口令时取出盐
            System.arraycopy(salt, 0, pwd, 0, SALT_LENGTH);
            // 将消息摘要拷贝到加密口令字节数组从第 13 个字节开始的字节
            System.arraycopy(digest, 0, pwd, SALT_LENGTH, digest.length);
            // 将字节数组格式加密后的口令转化为 16 进制字符串格式的口令
            return byteToHexString(pwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 验证密码
     * @param original 待验证的密码
     * @param cipher 加密后的密码
     * @return 是否验证成功
     */
    public static boolean verify(String original, String cipher){
        try {
            // 将 16 进制字符串格式口令转换成字节数组
            byte[] pwdInDb = hexStringToByte(cipher);
            // 声明盐变量
            byte[] salt = new byte[SALT_LENGTH];
            // 将盐从数据库中保存的口令字节数组中提取出来
            System.arraycopy(pwdInDb, 0, salt, 0, SALT_LENGTH);
            // 创建消息摘要对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 将盐数据传入消息摘要对象
            md.update(salt);
            // 将口令的数据传给消息摘要对象
            md.update(original.getBytes(StandardCharsets.UTF_8));
            // 生成输入口令的消息摘要
            byte[] digest = md.digest();
            // 声明一个保存数据库中口令消息摘要的变量
            byte[] digestInDb = new byte[pwdInDb.length - SALT_LENGTH];
            // 取得数据库中口令的消息摘要
            System.arraycopy(pwdInDb, SALT_LENGTH, digestInDb, 0,digestInDb.length);
            // 比较根据输入口令生成的消息摘要和数据库中消息摘要是否相同
            return Arrays.equals(digest, digestInDb);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}