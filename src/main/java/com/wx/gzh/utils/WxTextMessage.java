package com.wx.gzh.utils;

import java.util.Map;

/**
 * 微信文本类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class WxTextMessage extends WxBaseMessgae {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WxTextMessage(Map<String, String> map, String content) {
        super(map);
        // 设置文本消息格式为text
        this.setMsgType("text");
        this.content = content;
    }

    @Override
    public String toString() {
        return "WxTextMessage{" + "content = " + content + ", toUserName = " + getToUserName() + ", fromUserName = " + getFromUserName() + ", createTime = " + getCreateTime() +'}';
    }
}
