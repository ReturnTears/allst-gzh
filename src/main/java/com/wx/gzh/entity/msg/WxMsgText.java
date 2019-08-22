package com.wx.gzh.entity.msg;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:02
 */
public class WxMsgText {
    private String id;
    private String content;
    private String msgId;
    private String release1;
    private String release2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "WxMsgText{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", msgId='" + msgId + '\'' +
                ", release1='" + release1 + '\'' +
                ", release2='" + release2 + '\'' +
                '}';
    }
}
