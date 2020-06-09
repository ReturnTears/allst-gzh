package com.wx.gzh.entity.joint;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;
import lombok.Data;

/**
 * Voice
 * @author  Junn
 * @since  2019/6/20 0020下午 14:07
 */
@Data
public class Voice {
    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XStreamAlias("MediaId")
    @XStreamCDATA
    private String MediaId;
}
