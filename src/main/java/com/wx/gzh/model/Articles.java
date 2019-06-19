package com.wx.gzh.model;

/**
 *
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class Articles {
    /**
     * ArticleCount	是	图文消息个数；当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
     * Articles	是	图文消息信息，注意，如果图文数超过限制，则将只发限制内的条数
     * Title	是	图文消息标题
     * Description	是	图文消息描述
     * PicUrl	是	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     * Url	是	点击图文消息跳转链接
     */
    private String title;
    private String description;
    private String picUrl;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
