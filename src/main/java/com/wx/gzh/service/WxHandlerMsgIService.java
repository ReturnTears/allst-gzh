package com.wx.gzh.service;

import java.util.Map;

/**
 * 服务端处理所有的事件,消息回复,消息推送
 * @author JUNN
 * @since 2019/6/19 0019
 */
public interface WxHandlerMsgIService {
    /**
     * 消息回复
     * @param params
     *                  回复用户的消息数据包
     * @return
     *                  消息XML格式数据
     */
    String handlerMsgs(Map<String, String> params);

    /**
     * 回复消息
     * replyMsg
     * @return
     */
    String handlerEvent(String msgType);

    /**
     * 推送消息
     * @return
     */
    String pushMsg();
}
