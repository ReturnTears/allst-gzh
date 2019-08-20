package com.wx.gzh.entity.msg;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:07
 */
public class WxMsgLocation {
    private int msgForeignKey;
    private double Location_X;
    private double Location_Y;
    private int Scale;
    private String Label;
    private String release1;
    private String release2;

    public int getMsgForeignKey() {
        return msgForeignKey;
    }

    public void setMsgForeignKey(int msgForeignKey) {
        this.msgForeignKey = msgForeignKey;
    }

    public double getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(double location_X) {
        Location_X = location_X;
    }

    public double getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(double location_Y) {
        Location_Y = location_Y;
    }

    public int getScale() {
        return Scale;
    }

    public void setScale(int scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
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
