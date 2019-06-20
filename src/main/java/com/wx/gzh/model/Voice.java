package com.wx.gzh.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;

/**
 * Voice
 * @Auther Junn
 * @Date 2019/6/20 0020下午 14:07
 */
public class Voice {
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
