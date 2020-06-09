package com.wx.gzh.entity.msg;

import lombok.Data;
import lombok.ToString;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:05
 */
@Data
@ToString
public class WxMsgLink {
    private Integer id;
    private String Title;
    private String Description;
    private String Url;
    private String msgId;
    private String release1;
    private String release2;
}
