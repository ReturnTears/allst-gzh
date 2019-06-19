package com.wx.gzh.utils;

import com.wx.gzh.model.Video;

import java.util.Map;

/**
 * 微信视频类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class WxVideoMessage extends WxBaseMessgae {
    /**
     * MediaId	是	通过素材管理中的接口上传多媒体文件，得到的id
     * Title	否	视频消息的标题
     * Description
     */
    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public WxVideoMessage(Video video) {
        this.video = video;
    }

    public WxVideoMessage(Map<String, String> map, Video video) {
        super(map);
        setMsgType("video");
        this.video = video;
    }
}
