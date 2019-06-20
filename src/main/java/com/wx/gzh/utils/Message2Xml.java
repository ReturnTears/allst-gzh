package com.wx.gzh.utils;

import com.thoughtworks.xstream.XStream;

import java.util.Date;
import java.util.Map;

/**
 * 将Message转换为XML格式工具类
 * @Auther Junn
 * @Date 2019/6/20 0020上午 9:29
 */
public class Message2Xml {

    private static final XStream xStream = XStreamFactory.getXStream();

    /**
     * 将发送消息封装为对应的xml格式
     * @return
     */
    private static String convertToXml(Object object) {
        xStream.processAnnotations(object.getClass());
        return xStream.toXML(object);
    }

    /**
     * 封装发送消息对象,封装时，需要将调换发送者和接收者的关系
     * @return
     */
    public static String initMessage(Map<String, String> map) {
        WxTextMessage text = new WxTextMessage();
        text.setToUserName(map.get("FromUserName"));
        text.setFromUserName(map.get("ToUserName"));
        text.setContent(map.get("Content"));
        text.setCreateTime(map.get("CreateTime"));
        text.setMsgType(map.get("MsgType"));
        return convertToXml(text);
    }

}
