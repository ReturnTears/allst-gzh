package com.wx.gzh.service;

import com.wx.gzh.entity.user.WxUserInfo;
import net.sf.json.JSONObject;

/**
 * Wx用户信息
 * @author  JUNN
 * @since 2019-07-08 下午 10:50
 */
public interface WxUserInfoIService {

    /**
     * 正常情况下，微信会返回下述JSON数据包给公众号
     * @param openId
     *              微信用户的openId
     * @return
     */
    JSONObject getUserInfos(String openId);

    /**
     * 保存微信用户信息
     * @param userInfo
     *                  WxUserInfo对象
     * @return
     *                  1 success 0 fail
     */
    int insertUserInfo(WxUserInfo userInfo);

    /**
     * 判断是否已存在用户
     * @param username
     *                      用户名
     * @param password
     *                      密码
     * @return
     *                      存在返回true， 不存在返回false
     */
    boolean isUserInfo(String username, String password);
}
