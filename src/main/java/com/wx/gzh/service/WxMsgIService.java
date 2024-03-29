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
     *          成功返回1, 失败返回!1
     */
    int insertMsg(WxMsg wxMsg);

    /**
     * 多媒体消息存放
     * @return
     *          成功返回1, 失败返回!1
     */
    int insertMsgMediaStore(WxMsgMedia wxMsgMedia);

    /**
     * 文本消息存放
     * @return
     *          成功返回1, 失败返回!1
     */
    int insertMsgContentStore(WxMsgText wxMsgContent);

    /**
     * 链接信息存放
     * @return
     *          成功返回1, 失败返回!1
     */
    int insertMsgLinkStore(WxMsgLink wxMsgLink);

    /**
     * 位置信息存放
     * @return
     *          成功返回1, 失败返回!1
     */
    int insertMsgLocationStore(WxMsgLocation wxMsgLocation);

    /**
     * 通过参数(微信名称/手机号/身份证号/系统ID)查询指定用户信息
     * @param params
     *                      查询参数
     * @return
     *                      用户信息集合
     */
    Map<String, Object> selectUserInfo(Map<String, Object> params);

    /**
     * 发送模板消息
     * @return
     *              成功返回true, 失败返回false
     */
    boolean sendTempMessage(Map<String, Object> params);
}
