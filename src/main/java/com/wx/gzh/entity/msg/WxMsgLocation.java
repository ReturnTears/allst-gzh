package com.wx.gzh.entity.msg;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:07
 */
public class WxMsgLocation {
    private String msgForeignKey;
    private Double Location_X;
    private Double Location_Y;
    private Integer Scale;
    private String Label;
    private String release1;
    private String release2;

    public String getMsgForeignKey() {
        return msgForeignKey;
    }

    public void setMsgForeignKey(String msgForeignKey) {
        this.msgForeignKey = msgForeignKey;
    }

    public Double getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(Double location_X) {
        Location_X = location_X;
    }

    public Double getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(Double location_Y) {
        Location_Y = location_Y;
    }

    public Integer getScale() {
        return Scale;
    }

    public void setScale(Integer scale) {
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

    @Override
    public String toString() {
        return "WxMsgLocation{" +
                "msgForeignKey=" + msgForeignKey +
                ", Location_X=" + Location_X +
                ", Location_Y=" + Location_Y +
                ", Scale=" + Scale +
                ", Label='" + Label + '\'' +
                ", release1='" + release1 + '\'' +
                ", release2='" + release2 + '\'' +
                '}';
    }
}
