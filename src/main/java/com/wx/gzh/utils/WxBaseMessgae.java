package com.wx.gzh.utils;

import java.util.Map;

/**
 * BaseMessage:
 * 以下四个参数为消息公共参数:
 * ToUserName   	接收方帐号（收到的OpenID）
 * FromUserName		开发者微信号
 * CreateTime		消息创建时间 （整型）
 * MsgType          消息类型
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class WxBaseMessgae {

    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    // 显示定义无参构造
    public WxBaseMessgae() {
    }

    public WxBaseMessgae(Map<String, String> map) {
        this.toUserName = map.get("FromUserName");
        this.fromUserName = map.get("ToUserName");
        this.createTime = String.valueOf(System.currentTimeMillis() / 1000);
    }
}
