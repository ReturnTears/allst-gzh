package com.wx.gzh.service;

import java.util.Map;

/**
 * 服务端处理所有的事件和消息回复
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public interface WxHandlerEventMsgService {

    String handlerEventAndMsg(Map<String, String> params);
}
