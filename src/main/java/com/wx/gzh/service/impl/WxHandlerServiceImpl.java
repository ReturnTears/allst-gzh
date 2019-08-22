package com.wx.gzh.service.impl;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.constant.Constant;
import com.wx.gzh.entity.msg.WxMsg;
import com.wx.gzh.entity.msg.WxMsgText;
import com.wx.gzh.service.WxHandlerMsgIService;
import com.wx.gzh.service.WxMsgIService;
import com.wx.gzh.utils.DateTimeUtil;
import com.wx.gzh.utils.Message2Xml;
import com.wx.gzh.utils.WxMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

import static com.wx.gzh.utils.WxMsgUtil.*;

/**
 * 服务端处理所有的事件,消息回复以及消息推送
 * @author JUNN
 * @since  2019/6/19 0019
 */
@Service
public class WxHandlerServiceImpl implements WxHandlerMsgIService {

    @Autowired
    private WxMsgIService wxMsgIService;

    @Override
    public String replayMsgs(Map<String, String> params) {
        String uuid = UUID.randomUUID().toString();
        String currentTime = String.valueOf(System.currentTimeMillis());
        // 消息接收者
        String toUserName = params.get("ToUserName");
        // 消息发送者
        String fromUserName = params.get("FromUserName");
        // 消息类型
        String msgType = params.get("MsgType");
        switch (msgType){
            // 处理文本消息
            case Constant.RESP_MESSAGE_TYPE_TEXT:
                String content = params.get("Content");
                // TODO 这里可以增加根据关键字回复功能
                if ("" == content) {
                    System.out.println("关键字处理逻辑");
                    // TODO 关键字处理逻辑
                }
                Integer time = DateTimeUtil.Date2Timestamp();
                WxMsg wxMsg = new WxMsg();
                wxMsg.setToUserName(fromUserName);
                wxMsg.setFromUserName(toUserName);
                wxMsg.setCreateTime(String.valueOf(time));
                wxMsg.setMsgType(msgType);
                wxMsg.setMsgId(params.get("MsgId"));
                wxMsg.setUid(uuid);
                wxMsg.setMsgKey(currentTime);
                wxMsg.setMsgSource(CommEnum.MsgSource.服务器.getValue());
                int result = wxMsgIService.insertMsg(wxMsg);
                if (result == 1) {
                    String responseStr = WxMsgUtil.replyTlMsg(params.get("Content"));
                    WxMsgText wxMsgText = new WxMsgText();
                    wxMsgText.setMsgId(currentTime);
                    wxMsgText.setContent(responseStr);
                    wxMsgIService.insertMsgContentStore(wxMsgText);
                    params.put("Content", responseStr);
                }
                return Message2Xml.initTextMessage(params);
                // return dealTextMessgae(params);

            // 处理图片消息
            case Constant.RESP_MESSAGE_TYPE_IMAGE:
                return dealImageMessage(params);
            // 处理语音消息
            case Constant.RESP_MESSAGE_TYPE_VOICE:
                return dealVoiceMessage(params);
            // 处理视频消息
            case Constant.RESP_MESSAGE_TYPE_VIDEO:
                return dealVideoMessage(params);
            // 处理音乐消息
            case Constant.RESP_MESSAGE_TYPE_MUSIC:
                return dealMusicMessage(params);
            // 处理图文消息
            case Constant.RESP_MESSAGE_TYPE_NEWS:
                return dealNewsMessage(params);
            // 处理位置信息消息
            case Constant.REQ_MESSAGE_TYPE_LOCATION:
                // TODO 处理位置消息以及事件处理
                return "";
            // Other
            default:
                return null;
        }
    }

    /**
     *
     * 处理事件
     * @return
     */
    @Override
    public String handlerEvent() {
        return null;
    }

    /**
     * 推送消息(发送模板消息)
     * @return
     */
    @Override
    public String pushMsg() {
        /**
         * <xml>
         *   <ToUserName><![CDATA[o_Ag01ZEmXLI2gCkgSaCmn6FYbmI]]></ToUserName>
         *   <FromUserName><![CDATA[gh_bd946e215c89]]></FromUserName>
         *   <CreateTime>1566462069</CreateTime>
         *   <MsgType><![CDATA[text]]></MsgType>
         *   <Content><![CDATA[哈喽！]]></Content>
         * </xml>
         */

        return "";
    }


}
