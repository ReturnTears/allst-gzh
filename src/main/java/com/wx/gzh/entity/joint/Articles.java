package com.wx.gzh.entity.joint;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;
import lombok.Data;

/**
 * Articles
 * @author  Junn
 * @since  2019/6/19 0019
 */
@Data
@XStreamAlias("item")
public class Articles {
    /**
     * 图文消息标题
     */
    @XStreamAlias("Title")
    @XStreamCDATA
    private String Title;
    /**
     * 图文消息描述
     */
    @XStreamAlias("Description")
    @XStreamCDATA
    private String Description;
    /**
     * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    @XStreamAlias("PicUrl")
    @XStreamCDATA
    private String PicUrl;
    /**
     * 点击图文消息跳转链接
     */
    @XStreamAlias("Url")
    @XStreamCDATA
    private String Url;

}
