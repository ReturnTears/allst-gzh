package com.wx.gzh.utils;

import com.wx.gzh.constant.Constant;
import com.wx.gzh.model.WxImageMessage;
import com.wx.gzh.robot.TuLingRobot;
import net.sf.json.JSONObject;
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

import static com.wx.gzh.robot.TuLingRobot.*;
import static com.wx.gzh.utils.Message2Xml.*;

/**
 * 微信消息类型以及消息内容格式转换
 * @author Junn
 * @since 2019/6/19 0019
 */
public class WxMsgUtil {

    /**
     * ---------------------------------------------------xml转map------------------------------------------------
     * 解析微信服务器发过来的xml格式的消息将其转换为map
     * @param request
     * @return
     */
    public static Map<String, String> xmlParseMap(HttpServletRequest request) throws IOException, DocumentException {
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
     * ---------------------------------------------------xml转json------------------------------------------------
     * 解析微信服务器发过来的xml格式的消息将其转换为JSON
     * @param request
     *                 HttpServletRequest
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static JSONObject xmlParseJson(HttpServletRequest request) throws IOException, DocumentException {

        return null;
    }

    /**
     * 处理消息或者事件
     * @return
     *
     */
    public static String handlerMsgOrEvent() {
        return null;
    }

    /**
     * 处理文本回复, 这里回复的格式应为<xml></xml>(带有CDATA的格式)
     * @param map
     * @return
     */
    public static String dealTextMessgae(Map<String, String> map) {
        // System.out.println("进入处理文本回复方法............");
        // WxTextMessage textMessage = new WxTextMessage(map, "欢迎使用微信公众号");
        // map.put("Content", "欢迎使用微信接口测试号，这是一条文本类型消息回复");
        // 将自定义消息改为机器人回复
        String question = map.get("Content");
        System.out.println("quest : " + question);
        if ("登陆".equals(question)) {
            String url = Constant.WX_OAuth2_Code.replace("APPID", Constant.APPID)
                                            .replace("REDIRECT_URI", Constant.URL)      // 这里的URI应为项目下的重定向地址，需要和网页授权的 授权回调页面域名一致
                                            .replace("SCOPE", Constant.WX_SNSAPI_USERINFO);
            String cont = "点击<a href='" + url + "'>这里</a>登陆";
            // todo 未完待处理
            map.put("Content", cont);
        } else {
            System.out.println("不在进入该方法.....");
            String reqStr = getRequestParams(question);
            String respStr = tulinPost(Constant.APIURL, reqStr);
            String talk = getResultMes(respStr);
            map.put("Content", talk);
        }
        // System.out.println(textXml);
        return initTextMessage(map);
    }

    /**
     * 机器人回复功能
     * @param accetpContent
     *                          接收的内容
     * @return
     *                          机器人的回复
     */
    public static String replyTlMsg(String accetpContent) {
        String tempContent = TuLingRobot.getRequestParams(accetpContent);
        String tempRespStr = TuLingRobot.tulinPost(Constant.APIURL, tempContent);
        return TuLingRobot.getResultMes(tempRespStr);
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

    /**
     * 封装消息模板数据为JSON对象
     * @param params
     *                  模板数据Map
     *                  template_id: 微信公众平台消息模板ID(需要申请)：ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY
     *                  touser: 消息接收openId
     *                  url: 点击模板消息需要跳转的地址(根据具体业务而定)
     *                  topcolor: 颜色
     *                  data: 将实例属性封装在JSON字符串中
     * @return
     *                  JSON对象
     */
    public static String tempMsg2JSON(Map<String, Object> params) {
        if (CoreToolsUtil.isNotEmpty(params)) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("{");
            buffer.append(String.format("\"touser\":\"%s\"", params.get("touser"))).append(",");
            buffer.append(String.format("\"template_id\":\"%s\"", params.get("template_id"))).append(",");
            buffer.append(String.format("\"topcolor\":\"%s\"", params.get("topcolor"))).append(",");
            buffer.append(String.format("\"url\":\"%s\"", params.get("url"))).append(",");
            buffer.append(String.format("\"data\":{"));
            // 拼接数据内容
            List<Map<String, Object>> list = (List<Map<String, Object>>) params.get("data");
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    buffer.append(String.format("\"%s\":{\"value\":\"%s\",\"color\":\"%s\"},", list.get(i).get("name"), list.get(i).get("value"), list.get(i).get("color")));
                } else {
                    buffer.append(String.format("\"%s\":{\"value\":\"%s\",\"color\":\"%s\"}", list.get(i).get("name"), list.get(i).get("value"), list.get(i).get("color")));
                }
            }
            buffer.append("}").append("}");
            System.out.println("转换的JSON串为：" + buffer.toString());
            return buffer.toString();
        }
        return "";
    }

}
