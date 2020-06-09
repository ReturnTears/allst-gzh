package com.wx.gzh.utils;

import com.wx.gzh.constant.Constant;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.wx.gzh.constant.Constant.TOKEN;

/**
 * 接入微信公众平台工具类
 * @author JUNN
 * @since 2019-09-08 下午 03:11
 */
public class WxJointUtil {

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static boolean validate(HttpServletRequest req) {
        String signature = req.getParameter("signature");// 微信加密签名
        String timestamp = req.getParameter("timestamp");// 时间戳
        String nonce = req.getParameter("nonce");// 随机数
        List<String> list = new ArrayList<>();
        list.add(TOKEN);// 同令牌token一致
        list.add(timestamp);
        list.add(nonce);
        Collections.sort(list);//字典排序
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s += (String) list.get(i);
        }
        if (encode("SHA1", s).equalsIgnoreCase(signature)) {
            return true;
        } else {
            return false;
        }
    }

    private static String encode(String algorithm, String str) {
        if (str == null) {
            return null;
        }
        try {
            //Java自带的加密类
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            //转为byte
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    /**
     * 接入验证方式2， 验证消息确实来自微信服务器
     *          1）将token、timestamp、nonce三个参数进行字典序排序
     *          2）将三个参数字符串拼接成一个字符串进行sha1加密
     *          3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     * @param timestamp     时间戳
     * @param nonce         随机数
     * @param signature     微信加密签名
     * @return              验证成功:true, 验证失败false
     */
    public boolean check(String timestamp, String nonce, String signature) {
        // 1
        String[] strs = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(strs);
        // 2 将拍下后的结果拼成一个字符串
        String str = strs[0].concat(strs[1]).concat(strs[2]);
        String mySign = Sha1Util.sha1(str);
        // 3
        return mySign.equalsIgnoreCase(signature);
    }

}
