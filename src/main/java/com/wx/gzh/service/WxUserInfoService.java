package com.wx.gzh.service;

import com.wx.gzh.entity.WxUserInfo;
import net.sf.json.JSONObject;

/**
 * Wx用户信息
 * @Auther JUNN
 * @Date 2019-07-08 下午 10:50
 */
public interface WxUserInfoService {

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

}
