package com.wx.gzh.tools;

/**
 * 自定义菜单事件
 * @Auther Junn
 * @Date 2019/6/21 0021上午 11:11
 */
public class WxMenuEvent extends WxBaseEvent {
    /**
     * 事件Key值，与自定义菜单接口中的Key值对应
     */
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
