package com.wx.gzh.tools;

import com.wx.gzh.constant.CommEnum;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * URL工具类
 * @Auther Junn
 * @Date 2019/6/26 0026下午 13:53
 */
public class URLTools {

    /**
     * URL编码
     * @param url
     * @return
     */
    public static String encodeUTF8Url(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, CommEnum.EncodingMode.UTF8编码.getValue());
    }

    /**
     * URL解码
     * @param url
     * @return
     */
    public static String decodeUTF8Url(String url) throws UnsupportedEncodingException {
        return URLDecoder.decode(url, CommEnum.EncodingMode.UTF8编码.getValue());
    }
}
