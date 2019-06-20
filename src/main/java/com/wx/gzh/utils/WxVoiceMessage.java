package com.wx.gzh.utils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.model.Voice;

import java.util.Map;

/**
 * 微信语言类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@XStreamAlias("xml")
public class WxVoiceMessage extends WxBaseMessgae {

    @XStreamAlias("Voice")
    private Voice Voice;

    public com.wx.gzh.model.Voice getVoice() {
        return Voice;
    }

    public void setVoice(com.wx.gzh.model.Voice voice) {
        Voice = voice;
    }

    public WxVoiceMessage() {
    }

    public WxVoiceMessage(Map<String, String> map) {
        super(map);
        this.setMsgType("voice");
    }

    @Override
    public String toString() {
        return "WxVoiceMessage{" +
                "Voice='" + Voice + '\'' +
                '}';
    }
}
