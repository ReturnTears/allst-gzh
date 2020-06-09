package com.wx.gzh.entity.msg;

import lombok.Data;
import lombok.ToString;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:02
 */
@Data
@ToString
public class WxMsgText {
    private Integer id;
    private String content;
    private String msgId;
    private String release1;
    private String release2;
}
