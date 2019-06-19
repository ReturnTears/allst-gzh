package com.wx.gzh.model;

/**
 * Video Model类型
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class Video {
    /**
     * <Video>
     *     <MediaId><![CDATA[media_id]]></MediaId>
     *     <Title><![CDATA[title]]></Title>
     *     <Description><![CDATA[description]]></Description>
     *   </Video>
     */
    private String mediaId;
    private String title;
    private String description;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

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
}
