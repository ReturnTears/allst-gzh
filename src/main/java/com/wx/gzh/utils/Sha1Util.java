package com.wx.gzh.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Sha1加密工具类
 * @author JUNN
 * @since 2019/6/19 0019
 */
public class Sha1Util {

    public static String sha1(String params) {
        try {
            // 获取一个加密对象
            MessageDigest md = MessageDigest.getInstance("sha1");
            // 加密
            byte[] digest = md.digest(params.getBytes());
            char[] chars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb = new StringBuilder();
            // 处理加密结果
            for (byte b : digest) {
                sb.append(chars[(b >>> 4) & 0X0F]);
                sb.append(chars[b & 0X0F]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
