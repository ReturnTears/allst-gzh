package com.wx.gzh.service.impl;

import com.wx.gzh.constant.MsgTypeConstant;
import com.wx.gzh.service.WxHandlerEventMsgService;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.wx.gzh.utils.WxMsgUtil.*;

/**
 * 服务端处理所有的事件和消息回复
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@Service
public class WxHandlerEventMsgServiceImpl implements WxHandlerEventMsgService {

    @Override
    public String handlerEventAndMsg(Map<String, String> params) {
        String msgType = params.get("MsgType");
        switch (msgType){
            // 处理文本消息
            case MsgTypeConstant.RESP_MESSAGE_TYPE_TEXT:
                return dealTextMessgae(params);
            case MsgTypeConstant.RESP_MESSAGE_TYPE_IMAGE:
                return dealImageMessage(params);
            case MsgTypeConstant.RESP_MESSAGE_TYPE_VOICE:
                return dealVoiceMessage(params);
            case MsgTypeConstant.RESP_MESSAGE_TYPE_VIDEO:
                return dealVideoMessage(params);
            case MsgTypeConstant.RESP_MESSAGE_TYPE_MUSIC:
                return dealMusicMessage(params);
            case MsgTypeConstant.RESP_MESSAGE_TYPE_NEWS:
                return dealNewsMessage(params);
            case MsgTypeConstant.REQ_MESSAGE_TYPE_LOCATION:
                // TODO 处理位置消息以及事件处理
                return "";
            default:
                return null;
        }
    }

}
