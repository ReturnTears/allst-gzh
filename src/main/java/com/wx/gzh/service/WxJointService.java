package com.wx.gzh.service;

/**
 * 微信接入Service
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public interface WxJointService {
    /**
     * 接入验证
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    boolean check(String timestamp, String nonce, String signature);
}
