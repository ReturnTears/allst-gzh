package com.wx.gzh.service.impl;

import com.wx.gzh.service.WxJoinService;
import com.wx.gzh.utils.Sha1Util;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@Service
public class WxJoinServiceImpl implements WxJoinService {

    private static final String TOKEN = "hyj";

    /**
     * 接入验证， 验证消息确实来自微信服务器
     *  1）将token、timestamp、nonce三个参数进行字典序排序
     *  2）将三个参数字符串拼接成一个字符串进行sha1加密
     *  3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     * @return
     */
    @Override
    public boolean check(String timestamp, String nonce, String signature) {
        // 1
        String[] strs = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(strs);
        // 2
        String str = strs[0] + strs[1] + strs[2];
        String mySign = Sha1Util.sha1(str);
        // 3
        return mySign.equalsIgnoreCase(signature);
    }
}