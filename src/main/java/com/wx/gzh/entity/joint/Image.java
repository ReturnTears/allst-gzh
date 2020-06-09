package com.wx.gzh.entity.joint;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;
import lombok.Data;

/**
 * Image
 * @author  Junn
 * @since  2019/6/20 0020上午 11:58
 */
@Data
public class Image {
    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id。
     */
    @XStreamAlias("MediaId")
    @XStreamCDATA
    private String MediaId;

}
