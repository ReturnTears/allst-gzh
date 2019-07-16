package com.wx.gzh.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;

/**
 * Music Model类
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class Music {
    /**
     * 音乐标题
     */
    @XStreamAlias("Title")
    @XStreamCDATA
    private String Title;
    /**
     * 音乐描述
     */
    @XStreamAlias("Description")
    @XStreamCDATA
    private String Description;
    /**
     * 音乐链接
     */
    @XStreamAlias("MusicURL")
    @XStreamCDATA
    private String MusicURL;
    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    @XStreamAlias("HQMusicUrl")
    @XStreamCDATA
    private String HQMusicUrl;
    /**
     * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XStreamAlias("ThumbMediaId")
    @XStreamCDATA
    private String ThumbMediaId;

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

    public String getMusicURL() {
        return MusicURL;
    }

    public void setMusicURL(String musicURL) {
        MusicURL = musicURL;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
