package com.wx.gzh.tools;

/**
 * 上报地理位置事件
 * @Auther Junn
 * @Date 2019/6/21 0021上午 11:08
 */
public class WxLocationEvent extends WxBaseEvent {
    /**
     * 地理位置维度
     */
    private String Latitude;
    /**
     * 地理位置经度
     */
    private String Longitude;
    /**
     * 地理位置精度
     */
    private String Precision;

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }
}
