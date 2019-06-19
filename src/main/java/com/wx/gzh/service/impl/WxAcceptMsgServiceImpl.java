package com.wx.gzh.service.impl;

import com.wx.gzh.service.WxAcceptMsgService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@Service
public class WxAcceptMsgServiceImpl implements WxAcceptMsgService {

    /**
     * 接受微信用户的消息
     *
     * @return
     */
    @Override
    public String joinWxMsg(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
            request.setCharacterEncoding("UTF-8");
            // 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8
            response.setCharacterEncoding("UTF-8");
            ServletInputStream is = request.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
            System.out.println(sb.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
