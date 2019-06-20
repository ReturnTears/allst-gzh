package com.wx.gzh.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;

/**
 * Music Model类
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class Music {
    /**
     * <Music>
     *    <Title><![CDATA[TITLE]]></Title>
     *    <Description><![CDATA[DESCRIPTION]]></Description>
     *    <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
     *    <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
     *    <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
     * </Music>
     * Title	否	音乐标题
     * Description	否	音乐描述
     * MusicURL	否	音乐链接
     * HQMusicUrl	否	高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * ThumbMediaId	是	缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XStreamAlias("Title")
    @XStreamCDATA
    private String Title;

    @XStreamAlias("Description")
    @XStreamCDATA
    private String Description;

    @XStreamAlias("MusicURL")
    @XStreamCDATA
    private String MusicURL;

    @XStreamAlias("HQMusicUrl")
    @XStreamCDATA
    private String HQMusicUrl;

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
