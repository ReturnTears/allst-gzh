package com.wx.gzh.model;

/**
 * 微信通用接口凭证AccessToken
 * @Auther Junn
 * @Date 2019/6/24 0024下午 14:42
 */
public class WxAccessToken {

    private String token;
    private int expiresIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}
