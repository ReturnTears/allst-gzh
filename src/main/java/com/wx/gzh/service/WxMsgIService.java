package com.wx.gzh.service;

import com.wx.gzh.entity.msg.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 微信消息相关接口
 *              (发送消息，接收消息，微信服务消息)
 * @author JUNN
 * @since 2019/8/20 0020 下午 17:34
 */
public interface WxMsgIService {
    /**
     * 接受微信用户的消息
     * @param request
     *                  HttpServletRequest
     * @param response
     *                  HttpServletResponse
     * @return
     */
    Map<String, String> joinWxMsg(HttpServletRequest request, HttpServletResponse response);
    /**
     * 消息记录
     * @return
     */
    int insertMsg(WxMsg wxMsg);

    /**
     * 多媒体消息存放
     * @return
     */
    int insertMsgMediaStore(WxMsgMedia wxMsgMedia);

    /**
     * 文本消息存放
     * @return
     */
    int insertMsgContentStore(WxMsgText wxMsgContent);

    /**
     * 链接信息存放
     * @return
     */
    int insertMsgLinkStore(WxMsgLink wxMsgLink);

    /**
     * 位置信息存放
     * @return
     */
    int insertMsgLocationStore(WxMsgLocation wxMsgLocation);
}
