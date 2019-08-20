package com.wx.gzh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 程序接受微信用户发送过来的消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public interface WxAcceptMsgIService {
    /**
     *  接受微信用户的消息
     * @param request
     * @param response
     * @return
     */
    Map<String, String> joinWxMsg(HttpServletRequest request, HttpServletResponse response);

}
