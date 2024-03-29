package com.wx.gzh.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.entity.joint.Video;

import java.util.Map;

/**
 * 微信视频类型消息
 * @author Junn
 * @since 2019/6/19 0019
 */
@XStreamAlias("xml")
public class WxVideoMessage extends WxBaseMessgae {
    /**
     * MediaId	是	通过素材管理中的接口上传多媒体文件，得到的id
     * Title	否	视频消息的标题
     * Description
     */
    @XStreamAlias("Video")
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }

    public WxVideoMessage() {}

    public WxVideoMessage(Map<String, String> map) {
        super(map);
        setMsgType("video");
    }

    @Override
    public String toString() {
        return "WxVideoMessage{" +
                "Video=" + Video +
                '}';
    }
}
