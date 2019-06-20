package com.wx.gzh.utils;

import com.wx.gzh.model.Video;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.wx.gzh.utils.Message2Xml.initMessage;

/**
 * 微信消息类型以及消息内容格式转换
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class WxMsgUtil {
    /**
     * 请求消息类型：文本
     */
    public final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public final String REQ_MESSAGE_TYPE_IMAGE="image";

    /**
     * 请求消息类型：语音
     */
    public final String REQ_MESSAGE_TYPE_VOICE="voice";

    /**
     * 请求消息类型：视频
     */
    public final String REQ_MESSAGE_TYPE_VIDEO="video";

    /**
     * 请求消息类型：链接
     */
    public final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public  final String REQ_MESSAGE_TYPE_LOCATION="location";

    /**
     * 请求消息类型：小视频
     */
    public final String REQ_MESSAGE_TYPE_SHORTVIDEO="shortvideo";

    /**
     *请求消息类型：事件推送
     */
    public final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 返回消息类型：文本
     */
    public final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 消息返回类型：图片
     */
    public final String RESP_MESSAGE_TYPE_IMAGE="image";

    /**
     * 消息返回类型:语音
     */
    public final String RESP_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 消息返回类型：音乐
     */
    public final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 消息返回类型：图文
     */
    public final  String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 消息返回类型：视频
     */
    public final String RESP_MESSAGE_TYPE_VIDEO="video";

    /**
     * 事件类型:订阅
     */
    public final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：取消订阅
     */
    public final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：scan(关注用户扫描带参二维码)
     */
    public final String EVENT_TYPE_SCAN = "scan";

    /**
     * 事件类型：location(上报地理位置)
     */
    public final String EVENT_TYPE_LOCATION = "location";

    /**
     * 事件类型：CLICK(点击菜单拉取消息)
     */
    public final String EVENT_TYPE_CLICK ="CLICK";

    /**
     * 事件类型：VIEW(自定义菜单URl视图)
     */
    public final String EVENT_TYPE_VIEW ="VIEW";

    /**
     * 事件类型：TEMPLATESENDJOBFINISH(模板消息送达情况提醒)
     */
    public final String EVENT_TYPE_TEMPLATESENDJOBFINISH="TEMPLATESENDJOBFINISH";

    /**
     * ---------------------------------------------------xml转map------------------------------------------------
     * 解析微信服务器发过来的xml格式的消息将其转换为map
     * @param request
     * @return
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws IOException, DocumentException {
        // 将解析结果存储在HashMap中
        Map<String, String>map =new HashMap<>();
        // 从request中得到输入流
        InputStream inputStream=request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到XML的根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        @SuppressWarnings("unchecked")
        List<Element> elementList = root.elements();
        // 判断又没有子元素列表
        if (elementList.size()==0){
            map.put(root.getName(), root.getText());
        } else {
            for (Element e : elementList)
                map.put(e.getName(), e.getText());
        }
        // 释放资源
        inputStream.close();
        // inputStream = null;
        // System.out.println("---------xml转换为map-----:" + map);
        return map;
    }

    /**
     * 处理文本回复, 这里回复的格式应为<xml></xml>(带有CDATA的格式)
     * @param map
     * @return
     */
    public static String dealTextMessgae(Map<String, String> map) {
        // System.out.println("进入处理文本回复方法............");
        // WxTextMessage textMessage = new WxTextMessage(map, "欢迎使用微信公众号");
        map.put("Content", "欢迎使用微信接口测试号，这是一条文本类型消息回复");
        String textXml = initMessage(map);
        // System.out.println(textXml);
        return textXml;
    }

    /**
     * 处理图片回复
     * @return
     */
    public static WxImageMessage dealImageMessage(Map<String, String> map) {
        WxImageMessage imageMessage = new WxImageMessage(map, "123");
        return imageMessage;
    }

    /**
     * 处理视频回复
     * @param map
     * @return
     */
    public static WxVideoMessage dealVideoMessage(Map<String, String> map) {
        Video video = new Video();
        WxVideoMessage videoMessage = new WxVideoMessage(map, video);
        return videoMessage;
    }

    /**
     * 处理语音回复
     * @param map
     * @return
     */
    public static WxVoiceMessage dealVoiceMessage(Map<String, String> map) {
        WxVoiceMessage voiceMessage = new WxVoiceMessage(map, "123");
        return voiceMessage;
    }


}
