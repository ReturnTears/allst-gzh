package com.wx.gzh.utils;

import java.util.Map;

/**
 * 微信图片类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class WxImageMessage extends WxBaseMessgae {

    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public WxImageMessage() {
    }

    public WxImageMessage(Map<String, String> map, String mediaId) {
        super(map);
        this.setMsgType("image");
        this.mediaId = mediaId;
}
}
