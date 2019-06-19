package com.wx.gzh.utils;

import com.wx.gzh.model.Music;

import java.util.Map;

/**
 * 微信音乐类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class WxMusicMessage extends WxBaseMessgae {

    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public WxMusicMessage(Music music) {
        this.music = music;
    }

    public WxMusicMessage(Map<String, String> map, Music music) {
        super(map);
        setMsgType("music");
        this.music = music;
    }

    @Override
    public String toString() {
        return "WxMusicMessage{" +
                "music=" + music +
                '}';
    }
}
