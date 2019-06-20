package com.wx.gzh.utils;

import com.thoughtworks.xstream.XStream;
import com.wx.gzh.model.Image;

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
     * 封装发送text类型消息对象,封装时，需要将调换发送者和接收者的关系
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[text]]></MsgType>
     *   <Content><![CDATA[你好]]></Content>
     * </xml>
     * @return
     */
    public static String initTextMessage(Map<String, String> map) {
        WxTextMessage text = new WxTextMessage();
        text.setToUserName(map.get("FromUserName"));
        text.setFromUserName(map.get("ToUserName"));
        text.setCreateTime(map.get("CreateTime"));
        text.setMsgType(map.get("MsgType"));
        text.setContent(map.get("Content"));
        return convertToXml(text);
    }

    /**
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[image]]></MsgType>
     *   <Image>
     *     <MediaId><![CDATA[media_id]]></MediaId>
     *   </Image>
     * </xml>
     * @param map
     * @return
     */
    public static String initImageMessage(Map<String, String> map) {
        Image pic = new Image();
        WxImageMessage image = new WxImageMessage();
        image.setMediaId(map.get(""));
        image.setToUserName(map.get("FromUserName"));
        image.setFromUserName(map.get("ToUserName"));
        image.setCreateTime(map.get("CreateTime"));
        image.setToUserName(map.get("FromUserName"));
        return "";
    }

}
