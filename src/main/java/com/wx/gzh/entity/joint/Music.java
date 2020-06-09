package com.wx.gzh.entity.joint;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;
import lombok.Data;

/**
 * Music Model类
 * @author  Junn
 * @since  2019/6/19 0019
 */
@Data
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
}
