package com.wx.gzh.utils;

import com.wx.gzh.constant.CommEnum;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;

/**
 * 项目核心工具方法
 * @author JUNN
 * @since 2019/6/26 0026下午 13:53
 */
public class CoreToolsUtil {

    // -----------------------------------------------编码 Start-------------------------------------------------------//
    /**
     * URL编码
     * @param url
     *                  URL
     * @return
     *                  编码后的URL
     */
    public static String encodeUTF8Url(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, CommEnum.EncodingMode.UTF8编码.getValue());
    }

    /**
     * URL解码
     * @param url
     *                  URL
     * @return
     *                  解码后的URL
     */
    public static String decodeUTF8Url(String url) throws UnsupportedEncodingException {
        return URLDecoder.decode(url, CommEnum.EncodingMode.UTF8编码.getValue());
    }

    // -----------------------------------------------编码 end---------------------------------------------------------//

    // ------------------------------------------判断对象是否为空 Start-------------------------------------------------//
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) return true;
        else if (obj instanceof CharSequence) return ((CharSequence) obj).length() == 0;
        else if (obj instanceof Collection) return ((Collection) obj).isEmpty();
        else if (obj instanceof Map) return ((Map) obj).isEmpty();
        else if (obj.getClass().isArray()) return Array.getLength(obj) == 0;

        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
    // ------------------------------------------判断对象是否为空 end---------------------------------------------------//
}
