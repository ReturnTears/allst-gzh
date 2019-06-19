package com.wx.gzh.service.impl;

import com.wx.gzh.service.WxAcceptMsgService;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import static com.wx.gzh.utils.WxMsgUtil.parseXml;

/**
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@Service
public class WxAcceptMsgServiceImpl implements WxAcceptMsgService {

    /**
     * 接受微信用户的消息
     * 参数	描述 :
     *      ToUserName	        开发者微信号
     *      FromUserName	    发送方帐号（一个OpenID）
     *      CreateTime	        消息创建时间 （整型）
     *      MsgType	            消息类型，文本为text
     *      Content	            文本消息内容
     *      MsgId	            消息id，64位整型
     * @return
     */
    @Override
    public String joinWxMsg(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
            request.setCharacterEncoding("UTF-8");
            // 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8
            response.setCharacterEncoding("UTF-8");

            // 解析xml消息格式为map
            Map<String, String> map = parseXml(request);
            System.out.println("解析后的内容为 : " + map);

            // 下面这部分内容为获取微信服务器发送过来的数据格式
            /*ServletInputStream is = request.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
            System.out.println(sb.toString());*/
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return "";
    }
}
