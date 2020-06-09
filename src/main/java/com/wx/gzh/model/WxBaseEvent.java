package com.wx.gzh.model;

import lombok.Data;

/**
 * 事件base类
 * @author  Junn
 * @since  2019/6/21 0021上午 10:55
 */
@Data
public class WxBaseEvent {

    private String ToUserName;
    private String FromUserName;
    private Long CreateTime;
    private String MsgType;
    private String Event;
}
