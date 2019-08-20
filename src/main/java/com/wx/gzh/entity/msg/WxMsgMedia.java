package com.wx.gzh.entity.msg;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:08
 */
public class WxMsgMedia {
    private int msgForeignKey;
    private String multimedia;
    private String release1;
    private String release2;

    public int getMsgForeignKey() {
        return msgForeignKey;
    }

    public void setMsgForeignKey(int msgForeignKey) {
        this.msgForeignKey = msgForeignKey;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
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
