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
    public static final String WX_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
    /**
     * 通过ticket换取二维码, 提醒：TICKET记得进行UrlEncode
     */
    public static final String WX_TICKET_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
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

    /**
     * --------------------------------------------------国家地区语言版本-------------------------------------------------
     * 简体
     */
    public static final String ZH_CN = "zh_CN";
    /**
     * 繁体
     */
    public static final String ZH_TW = "zh_TW";
    /**
     * 英语
     */
    public static final String EN = "en";

    /**
     * ------------------------------------------------获取用户基本信息---------------------------------------------------
     */
    public static final String WX_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /**
     * -----------------------------------------------用户关注的渠道来源--------------------------------------------------
     * 公众号搜索
     */
    private static final String ADD_SCENE_SEARCH = "ADD_SCENE_SEARCH";
    /**
     * 公众号迁移
     */
    private static final String ADD_SCENE_ACCOUNT_MIGRATION = "ADD_SCENE_ACCOUNT_MIGRATION";
    /**
     * 扫描二维码
     */
    private static final String ADD_SCENE_QR_CODE = "ADD_SCENE_QR_CODE";
    /**
     * 名片分享
     */
    private static final String ADD_SCENE_PROFILE_CARD = "ADD_SCENE_PROFILE_CARD";
    /**
     * 图文页内名称点击
     */
    private static final String ADD_SCENEPROFILE_LINK = "ADD_SCENEPROFILE_LINK";
    /**
     * 图文页右上角菜单
     */
    private static final String ADD_SCENE_PROFILE_ITEM = "ADD_SCENE_PROFILE_ITEM";
    /**
     * 支付后关注
     */
    private static final String ADD_SCENE_PAID = "ADD_SCENE_PAID";
    /**
     * 其他
     */
    private static final String ADD_SCENE_OTHERS = "ADD_SCENE_OTHERS";


}