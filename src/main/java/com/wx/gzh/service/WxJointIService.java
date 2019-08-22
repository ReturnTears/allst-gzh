package com.wx.gzh.service;

/**
 * 微信接入Service
 * @author JUNN
 * @since 2019/6/19 0019
 */
public interface WxJointIService {
    /**
     * 接入验证
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    boolean check(String timestamp, String nonce, String signature);
}
