package com.wx.gzh.constant;

import com.wx.gzh.model.AccessToken;

/**
 * 常量类
 * @Auther Junn
 * @Date 2019/6/24 0024下午 14:48
 */
public class Constant {
    /**
     * TOKEN
     */
    public static final String TOKEN = "hyj";
    /**
     * APPID
     */
    public static final String APPID = "wxd8dc984917fefba0";
    /**
     * APPSECRET
     */
    public static final String APPSECRET = "3950c17dacd4db2dbfc7bc7c06957cae";
    /**
     *  通过APPID和APPSECRET获取ACCESS_TOKEN的接口地址
     */
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 通过ACCESS_TOKEN创建公众号菜单的接口地址
     */
    public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";


}
