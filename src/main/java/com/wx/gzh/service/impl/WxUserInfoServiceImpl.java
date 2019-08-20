package com.wx.gzh.service.impl;

import com.wx.gzh.entity.user.WxUserInfo;
import com.wx.gzh.mapper.WxUserInfoMapper;
import com.wx.gzh.service.WxUserInfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Wx用户信息
 * @Auther JUNN
 * @Date 2019-07-08 下午 10:56
 */
@Service
@Transactional(value = "baseTransationManager")
public class WxUserInfoServiceImpl implements WxUserInfoService {

    @Autowired
    private WxUserInfoMapper userInfoMapper;

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

    /**
     * 保存微信用户信息
     *
     * @param userInfo WxUserInfo对象
     * @return 1 success 0 fail
     */
    @Override
    public int insertUserInfo(WxUserInfo userInfo) {
        String uuid = UUID.randomUUID().toString();
        userInfo.setUid(uuid);
        return userInfoMapper.insertSelective(userInfo);
    }


}
