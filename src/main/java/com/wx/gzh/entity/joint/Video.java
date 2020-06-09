package com.wx.gzh.entity.joint;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;
import lombok.Data;

/**
 * Video Model类型
 * @author  Junn
 * @since  2019/6/19 0019
 */
@Data
public class Video {
    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XStreamAlias("MediaId")
    @XStreamCDATA
    private String MediaId;
    /**
     * 视频消息的标题
     */
    @XStreamAlias("Title")
    @XStreamCDATA
    private String Title;
    /**
     * 视频消息的描述
     */
    @XStreamAlias("Description")
    @XStreamCDATA
    private String Description;

    @XStreamAlias("ThumbMediaId")
    @XStreamCDATA
    private String ThumbMediaId;
}
