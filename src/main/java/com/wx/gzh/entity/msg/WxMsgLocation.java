package com.wx.gzh.entity.msg;

import lombok.Data;
import lombok.ToString;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:07
 */
@Data
@ToString
public class WxMsgLocation {
    private Integer id;
    private Double Location_X;
    private Double Location_Y;
    private String Scale;
    private String Label;
    private String msgId;
    private String release1;
    private String release2;
}
