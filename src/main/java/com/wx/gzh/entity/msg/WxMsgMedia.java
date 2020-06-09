package com.wx.gzh.entity.msg;

import lombok.Data;
import lombok.ToString;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:08
 */
@Data
@ToString
public class WxMsgMedia {
    private Integer id;
    private String MediaId;
    private String PicUrl;
    private String Format;
    private String Recognition;
    private String ThumbMediaId;
    private String msgId;
    private String release1;
    private String release2;
}
