package com.wx.gzh.utils;

import com.wx.gzh.tools.WxImageMessage;
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

import static com.wx.gzh.utils.Message2Xml.*;

/**
 * 微信消息类型以及消息内容格式转换
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class WxMsgUtil {

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
        // System.out.println(textXml);
        return initTextMessage(map);
    }

    /**
     * 处理微信图片消息回复
     * @param map
     * @return
     */
    public static String dealImageMessage(Map<String, String> map) {
        WxImageMessage imageMessage = new WxImageMessage();
        // map.put("MediaId", "");
        return initImageMessage(map);
    }

    /**
     * 处理视频回复
     * @param map
     * @return
     */
    public static String dealVideoMessage(Map<String, String> map) {
        return initVideoMessage(map);
    }

    /**
     * 处理语音回复
     * @param map
     * @return
     */
    public static String dealVoiceMessage(Map<String, String> map) {
        return initVoiceMessage(map);
    }

    /**
     * 处理微信音乐消息回复
     * @param map
     * @return
     */
    public static String dealMusicMessage(Map<String, String> map) {
        return initMusicMessage(map);
    }

    /**
     * 处理微信图文消息回复
     * @param map
     * @return
     */
    public static String dealNewsMessage(Map<String, String> map) {
        return initNewsMessage(map);
    }

}
