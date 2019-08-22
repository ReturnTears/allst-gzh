package com.wx.gzh.entity.msg;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:07
 */
public class WxMsgLocation {
    private Integer id;
    private Double Location_X;
    private Double Location_Y;
    private String Scale;
    private String Label;
    private String msgId;
    private String release1;
    private String release2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
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
        return "WxMsgLocation{" +
                "id='" + id + '\'' +
                ", Location_X=" + Location_X +
                ", Location_Y=" + Location_Y +
                ", Scale='" + Scale + '\'' +
                ", Label='" + Label + '\'' +
                ", msgId='" + msgId + '\'' +
                ", release1='" + release1 + '\'' +
                ", release2='" + release2 + '\'' +
                '}';
    }
}
