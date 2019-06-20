package com.wx.gzh.utils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.model.Music;

import java.util.Map;

/**
 * 微信音乐类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@XStreamAlias("xml")
public class WxMusicMessage extends WxBaseMessgae {

    @XStreamAlias("Music")
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        this.Music = music;
    }

    public WxMusicMessage() {}

    public WxMusicMessage(Map<String, String> map) {
        super(map);
        setMsgType("music");
    }

    @Override
    public String toString() {
        return "WxMusicMessage{" +
                "Music=" + Music +
                '}';
    }
}
