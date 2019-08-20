package com.wx.gzh.entity.joint;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;

/**
 * Articles
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@XStreamAlias("item")
public class Articles {
    /**
     * 图文消息标题
     */
    @XStreamAlias("Title")
    @XStreamCDATA
    private String Title;
    /**
     * 图文消息描述
     */
    @XStreamAlias("Description")
    @XStreamCDATA
    private String Description;
    /**
     * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    @XStreamAlias("PicUrl")
    @XStreamCDATA
    private String PicUrl;
    /**
     * 点击图文消息跳转链接
     */
    @XStreamAlias("Url")
    @XStreamCDATA
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
