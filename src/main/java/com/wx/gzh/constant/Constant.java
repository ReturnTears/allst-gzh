package com.wx.gzh.constant;

import com.wx.gzh.model.AccessToken;

import java.nio.charset.StandardCharsets;

/**
 * 常量类
 * @Auther Junn
 * @Date 2019/6/24 0024下午 14:48
 */
public class Constant {
    /**
     * --------------------------------------------------------请求方式--------------------------------------------------
     *
     * GET请求
     */
    public static final String GET_METHOD = "GET";
    /**
     * POST请求
     */
    public static final String POST_METHOD = "POST";
    /**
     * PUT请求
     */
    public static final String PUT_METHOD = "PUT";
    /**
     * DELETE请求
     */
    public static final String DELETE_METHOD = "DELETE";
    /**
     * ----------------------------------------------------编码方式------------------------------------------------------
     *
     * UTF-8
     */
    public static final String UTF8Code = "UTF-8";
    /**
     * GBK
     */
    public static final String GBKCode = "GBK";
    /**
     * --------------------------------------------------接口配置信息-----------------------------------------------------
     *
     * TOKEN
     */
    public static final String TOKEN = "hyj";
    /**
     * URL
     */
    public static final String URL = "http://huwx.free.idcfengye.com/api/join";
    /**
     * --------------------------------------------------公众号信息------------------------------------------------------
     * APPID
     */
    public static final String APPID = "wxd8dc984917fefba0";
    /**
     * APPSECRET
     */
    public static final String APPSECRET = "3950c17dacd4db2dbfc7bc7c06957cae";
    /**
     * ----------------------------------------------ACCESS_TOKEN-------------------------------------------------------
     *
     *  通过APPID和APPSECRET获取ACCESS_TOKEN的接口地址
     */
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 通过ACCESS_TOKEN创建公众号菜单的接口地址
     */
    public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**
     * --------------------------------------------------二维码信息------------------------------------------------------
     *
     * 微信二维码 (临时二维码可以生成较多数量 / 永久二维码可以生成最多10W个)
     */
    public static final String WX_QRCODE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
    /**
     * 通过ticket换取二维码, 提醒：TICKET记得进行UrlEncode
     */
    public static final String WX_TICKET = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
    /**
     * --------------------------------------------------二维码类型------------------------------------------------------
     *
     * QR_SCENE为临时的整型参数值
     */
    public static final String QR_SCENE = "QR_SCENE";
    /**
     * QR_STR_SCENE为临时的字符串参数值
     */
    public static final String QR_STR_SCENE = "QR_STR_SCENE";
    /**
     * QR_LIMIT_SCENE为永久的整型参数值
     */
    public static final String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";
    /**
     * QR_LIMIT_STR_SCENE为永久的字符串参数值
     */
    public static final String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";
    /**
     * --------------------------------------------------系统参数--------------------------------------------------------
     */
    public static final String TMPDIR = System.getProperty("java.io.tmpdir");
}
