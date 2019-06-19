package com.wx.gzh.service.impl;

import com.wx.gzh.service.WxHandlerEventMsgService;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.wx.gzh.utils.WxMsgUtil.dealTextMessgae;

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
            case "text":
                dealTextMessgae(params);
                break;
            case "image":
                break;
            case "voice":
                break;
            case "video":
                break;
            case "music":
                break;
            case "news":
                break;
        }

        return null;
    }

}
