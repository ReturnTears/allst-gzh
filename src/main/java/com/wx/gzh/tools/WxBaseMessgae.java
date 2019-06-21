package com.wx.gzh.tools;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;

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
    /**
     * 接收方帐号（收到的OpenID）
     */
    @XStreamAlias("ToUserName")
    @XStreamCDATA
    private String ToUserName;
    /**
     * 开发者微信号
     */
    @XStreamAlias("FromUserName")
    @XStreamCDATA
    private String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    @XStreamAlias("CreateTime")
    private String CreateTime;
    /**
     *  消息类型
     */
    @XStreamAlias("MsgType")
    @XStreamCDATA
    private String MsgType;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    // 显示定义无参构造
    public WxBaseMessgae() {
        super();
    }

    public WxBaseMessgae(Map<String, String> map) {
        this.ToUserName = map.get("FromUserName");
        this.FromUserName = map.get("ToUserName");
        this.CreateTime = String.valueOf(System.currentTimeMillis() / 1000);
    }

    @Override
    public String toString() {
        return "WxBaseMessgae{" +
                "toUserName='" + ToUserName + '\'' +
                ", fromUserName='" + FromUserName + '\'' +
                ", createTime='" + CreateTime + '\'' +
                ", msgType='" + MsgType + '\'' +
                '}';
    }
}
