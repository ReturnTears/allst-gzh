package com.wx.gzh.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;

/**
 * Video Model类型
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class Video {
    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XStreamAlias("MediaId")
    @XStreamCDATA
    private String MediaId;
    /**
     * 视频消息的标题
     */
    @XStreamAlias("Title")
    @XStreamCDATA
    private String Title;
    /**
     * 视频消息的描述
     */
    @XStreamAlias("Description")
    @XStreamCDATA
    private String Description;

    @XStreamAlias("ThumbMediaId")
    @XStreamCDATA
    private String ThumbMediaId;

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

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
}
