package com.wx.gzh.entity.msg;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 微信发送/接收消息记录
 * @author JUNN
 * @since 2019/8/20 0020 下午 17:52
 */
@Data
@NoArgsConstructor
@ToString
public class WxMsg {
    private int id;
    private String uid;
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgId;
    private String MsgType;
    private Integer MsgSource;
    private String msgKey;
    private String release1;
    private String release2;
}
