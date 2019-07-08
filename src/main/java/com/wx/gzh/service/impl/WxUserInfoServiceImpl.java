package com.wx.gzh.service.impl;

import com.wx.gzh.service.WxUserInfoService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Wx用户信息
 * @Auther JUNN
 * @Date 2019-07-08 下午 10:56
 */
@Service
public class WxUserInfoServiceImpl implements WxUserInfoService {
    /**
     * 正常情况下，微信会返回下述JSON数据包给公众号
     *
     * @param openId 微信用户的openId
     * @return
     */
    @Override
    public JSONObject getUserInfos(String openId) {
        return null;
    }
}
