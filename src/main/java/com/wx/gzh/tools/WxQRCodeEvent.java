package com.wx.gzh.tools;

/**
 * 扫描参数带二维码事件
 * @Auther Junn
 * @Date 2019/6/21 0021上午 11:05
 */
public class WxQRCodeEvent extends WxBaseEvent {
    /**
     * 事件Key值
     */
    private String EventKey;
    /**
     * 用于换取二维码图片
     */
    private String Ticket;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }
}
