package com.wx.gzh.entity.token;

/**
 * 微信通用接口凭证AccessToken
 * 封装一个对象保存accesstoken
 * @Auther Junn
 * @Date 2019/6/24 0024下午 14:42
 */
public class AccessToken {
    /**
     * 获取到的凭证
     */
    private String access_token;
    /**
     * 凭证有效时间，单位：秒
     */
    private int expires_in;
    /**
     * 过期时间
     */
    private long expireTime;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public AccessToken() {
    }

    public AccessToken(String access_token, String expireIn) {
        super();
        this.access_token = access_token;
        expireTime = System.currentTimeMillis() + Integer.parseInt(expireIn) * 1000;
    }

    /**
     * 判断token是否过期
     * @return
     */
    public boolean isExpired() {
        return System.currentTimeMillis() > expireTime;
    }
}
