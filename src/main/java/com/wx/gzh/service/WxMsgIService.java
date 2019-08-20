package com.wx.gzh.service;

/**
 * 微信消息相关接口
 *              (发送消息，接收消息，微信服务消息)
 * @author JUNN
 * @since 2019/8/20 0020 下午 17:34
 */
public interface WxMsgIService {

    /**
     * 消息记录
     * @return
     */
    int insertMsg();

    /**
     * 多媒体消息存放
     * @return
     */
    int insertMsgMediaStore();

    /**
     * 文本消息存放
     * @return
     */
    int insertMsgContentStore();

    /**
     * 链接信息存放
     * @return
     */
    int insertMsgLinkStore();

    /**
     * 位置信息存放
     * @return
     */
    int insertMsgLocationStore();
}
