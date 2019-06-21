package com.wx.gzh.tools;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.model.Image;

import java.util.Map;

/**
 * 微信图片类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@XStreamAlias("xml")
public class WxImageMessage extends WxBaseMessgae {

    @XStreamAlias("Image")
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }

    public WxImageMessage() {
    }

    public WxImageMessage(Map<String, String> map) {
        super(map);
        this.setMsgType("image");
    }

    @Override
    public String toString() {
        return "WxImageMessage{" + "Image = '" + Image + '\'' + '}';
    }
}
