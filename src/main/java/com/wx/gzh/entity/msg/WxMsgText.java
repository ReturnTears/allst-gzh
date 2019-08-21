package com.wx.gzh.entity.msg;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:02
 */
public class WxMsgText {
    private String msgForeignKey;
    private String content;
    private String release1;
    private String release2;

    public String getMsgForeignKey() {
        return msgForeignKey;
    }

    public void setMsgForeignKey(String msgForeignKey) {
        this.msgForeignKey = msgForeignKey;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
