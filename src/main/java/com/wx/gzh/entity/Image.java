package com.wx.gzh.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;

/**
 * Image
 * @Auther Junn
 * @Date 2019/6/20 0020上午 11:58
 */
public class Image {
    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id。
     */
    @XStreamAlias("MediaId")
    @XStreamCDATA
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

}
