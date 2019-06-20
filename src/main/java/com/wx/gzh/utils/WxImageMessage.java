package com.wx.gzh.utils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;
import com.wx.gzh.model.Image;

import java.util.Map;

/**
 * 微信图片类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@XStreamAlias("xml")
public class WxImageMessage extends WxBaseMessgae {

    @XStreamAlias("MediaId")
    @XStreamCDATA
    private String MediaId;

    @XStreamAlias("Image")
    @XStreamCDATA
    private Image Image;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }

    public WxImageMessage() {
    }

    public WxImageMessage(Map<String, String> map, String mediaId) {
        super(map);
        this.setMsgType("image");
        this.MediaId = mediaId;
    }

    @Override
    public String toString() {
        return "WxImageMessage{" + "mediaId = '" + MediaId + '\'' + '}';
    }
}
