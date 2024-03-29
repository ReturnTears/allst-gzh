package com.wx.gzh.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;

import java.util.Map;

/**
 * 微信文本类型消息
 * @author Junn
 * @since 2019/6/19 0019
 */
@XStreamAlias("xml")
public class WxTextMessage extends WxBaseMessgae {
    /**
     * @XStreamAlias 注解是将属性变成Content形式，所以属性可以写成小写或者任意的形式
     */
    @XStreamAlias("Content")
    @XStreamCDATA
    private String Content;

    private String MsgId;

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        this.MsgId = msgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public WxTextMessage() {

    }
    // 根据官方的格式我们不需要msgId
    public WxTextMessage(Map<String, String> map, String content, String msgId) {
        super(map);
        this.Content = content;
        this.MsgId = msgId;
    }

    public WxTextMessage(Map<String, String> map, String content) {
        super(map);
        // 设置文本消息格式为text
        this.setMsgType("text");
        this.Content = content;
    }

    @Override
    public String toString() {
        return "WxTextMessage{" + "Content = " + Content + ", ToUserName = " + getToUserName() + ", FromUserName = " + getFromUserName() + ", CreateTime = " + getCreateTime() + ", MsgType = " + getMsgType() +'}';
    }
}
