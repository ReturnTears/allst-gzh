package com.wx.gzh.utils;

import java.util.Map;

/**
 * 微信语言类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class WxVoiceMessage extends WxBaseMessgae {

    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public WxVoiceMessage() {
    }

    public WxVoiceMessage(Map<String, String> map, String mediaId) {
        super(map);
        this.setMsgType("voice");
        this.mediaId = mediaId;
    }
}
