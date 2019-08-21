package com.wx.gzh.service.impl;

import com.wx.gzh.entity.msg.*;
import com.wx.gzh.mapper.*;
import com.wx.gzh.service.WxMsgIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static com.wx.gzh.utils.WxMsgUtil.xmlParseMap;

/**
 * WxMsgIService实现类
 * @author JUNN
 * @since 2019/8/21 0021 上午 9:36
 */
@Service
@Transactional(value = "baseTransationManager")
public class WxMsgServiceImpl implements WxMsgIService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxMsgServiceImpl.class);

    @Autowired
    private WxMsgMapper wxMsgMapper;

    @Autowired
    private WxMsgTextMapper wxMsgContentMapper;

    @Autowired
    private WxMsgMediaMapper wxMsgMediaMapper;

    @Autowired
    private WxMsgLocationMapper wxMsgLocationMapper;

    @Autowired
    private WxMsgLinkMapper wxMsgLinkMapper;

    /**
     * 接受微信用户的消息
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return
     */
    @Override
    public Map<String, String> joinWxMsg(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
            request.setCharacterEncoding("UTF-8");
            // 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8
            response.setCharacterEncoding("UTF-8");

            // 解析xml消息格式为map
            Map<String, String> map = xmlParseMap(request);
            System.out.println("解析后的内容为 : " + map);

            // 下面这部分内容为获取微信服务器发送过来的数据格式
            ServletInputStream is = request.getInputStream();
            byte[] b = new byte[2048];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
            System.out.println(sb.toString());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 消息记录
     *
     * @return
     */
    @Override
    public int insertMsg(WxMsg wxMsg) {
        return wxMsgMapper.insertSelective(wxMsg);
    }

    /**
     * 多媒体消息存放
     *
     * @return
     */
    @Override
    public int insertMsgMediaStore(WxMsgMedia wxMsgMedia) {
        return wxMsgMediaMapper.insertSelective(wxMsgMedia);
    }

    /**
     * 文本消息存放
     *
     * @return
     */
    @Override
    public int insertMsgContentStore(WxMsgText wxMsgContent) {
        return wxMsgContentMapper.insertSelective(wxMsgContent);
    }

    /**
     * 链接信息存放
     *
     * @return
     */
    @Override
    public int insertMsgLinkStore(WxMsgLink wxMsgLink) {
        return wxMsgLinkMapper.insertSelective(wxMsgLink);
    }

    /**
     * 位置信息存放
     *
     * @return
     */
    @Override
    public int insertMsgLocationStore(WxMsgLocation wxMsgLocation) {
        return wxMsgLocationMapper.insertSelective(wxMsgLocation);
    }
}
