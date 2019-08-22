package com.wx.gzh.entity.msg;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:08
 */
public class WxMsgMedia {
    private String id;
    private String MediaId;
    private String PicUrl;
    private String Format;
    private String Recognition;
    private String ThumbMediaId;
    private String msgId;
    private String release1;
    private String release2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getRelease1() {
        return release1;
    }

    public void setRelease1(String release1) {
        this.release1 = release1;
    }

    public String getRelease2() {
        return release2;
    }

    public void setRelease2(String release2) {
        this.release2 = release2;
    }

    @Override
    public String toString() {
        return "WxMsgMedia{" +
                "id='" + id + '\'' +
                ", MediaId='" + MediaId + '\'' +
                ", PicUrl='" + PicUrl + '\'' +
                ", Format='" + Format + '\'' +
                ", Recognition='" + Recognition + '\'' +
                ", ThumbMediaId='" + ThumbMediaId + '\'' +
                ", msgId='" + msgId + '\'' +
                ", release1='" + release1 + '\'' +
                ", release2='" + release2 + '\'' +
                '}';
    }
}
