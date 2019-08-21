package com.wx.gzh.service.impl;

import com.alibaba.fastjson.JSON;
import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.constant.Constant;
import com.wx.gzh.entity.msg.*;
import com.wx.gzh.service.WxAcceptMsgIService;
import com.wx.gzh.service.WxMsgIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

import static com.wx.gzh.utils.WxMsgUtil.xmlParseMap;

/**
 * @author Junn
 * @since 2019/6/19 0019
 */
@Service
public class WxAcceptMsgServiceImpl implements WxAcceptMsgIService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxAcceptMsgServiceImpl.class);

    @Autowired
    private WxMsgIService wxMsgIService;

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
    public Map<String, String> joinWxMsg(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
            request.setCharacterEncoding("UTF-8");
            // 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8
            response.setCharacterEncoding("UTF-8");

            // 解析xml消息格式为map
            Map<String, String> map = xmlParseMap(request);
            System.out.println("解析后的数据为:" + map);
            String currentTime = String.valueOf(System.currentTimeMillis());
            int saveResult = saveCommonMsg(map, currentTime);
            // 消息类型
            String msgType = map.get("MsgType");
            System.out.println("msgType : " + msgType);
            if (saveResult == 1) {
                switch (msgType) {
                    // 处理文本消息
                    case Constant.RESP_MESSAGE_TYPE_TEXT:
                        WxMsgText wxMsgText = new WxMsgText();
                        wxMsgText.setContent(map.get("Content"));
                        wxMsgText.setMsgForeignKey(currentTime);
                        wxMsgIService.insertMsgContentStore(wxMsgText);
                    case Constant.RESP_MESSAGE_TYPE_IMAGE:
                        WxMsgMedia wxMsgMedia = new WxMsgMedia();
                        wxMsgMedia.setMsgForeignKey(currentTime);
                        wxMsgMedia.setPicUrl(map.get("PicUrl"));
                        wxMsgMedia.setMediaId(map.get("MediaId"));
                        wxMsgIService.insertMsgMediaStore(wxMsgMedia);
                    case Constant.REQ_MESSAGE_TYPE_LOCATION:
                        WxMsgLocation wxMsgLocation = new WxMsgLocation();
                        wxMsgLocation.setMsgForeignKey(currentTime);
                        wxMsgLocation.setLabel(map.get("Label"));
                        wxMsgLocation.setLocation_X(Double.valueOf(map.getOrDefault("Location_X", "0.0")));
                        wxMsgLocation.setLocation_Y(Double.valueOf(map.getOrDefault("Location_Y", "0.0")));
                        wxMsgLocation.setScale(Integer.parseInt(map.get("Scale")));
                        wxMsgIService.insertMsgLocationStore(wxMsgLocation);
                    case Constant.REQ_MESSAGE_TYPE_LINK:
                        WxMsgLink wxMsgLink = new WxMsgLink();
                        wxMsgLink.setMsgForeignKey(currentTime);
                        wxMsgLink.setDescription(map.get("Description"));
                        wxMsgLink.setTitle(map.get("Title"));
                        wxMsgLink.setUrl(map.get("Url"));
                        wxMsgIService.insertMsgLinkStore(wxMsgLink);
                    default:
                        System.out.println("什么都没有执行");
                }
            } else {
                LOGGER.error("保存信息失败，errcode:{}" + saveResult);
            }

            // 文本消息内容
            String contentText = map.get("Content");

            /*// 保存用户发送过来的信息
            String uuid = UUID.randomUUID().toString();
            // Map转换为JavaBean
            WxMsg wxMsg = JSON.parseObject(JSON.toJSONString(map), WxMsg.class);
            String currentTime = String.valueOf(System.currentTimeMillis());
            wxMsg.setUid(uuid);
            wxMsg.setMsgForeignKey(currentTime);
            wxMsg.setMsgSource(CommEnum.MsgSource.用户.getValue());
            int res = wxMsgIService.insertMsg(wxMsg);

            if (res == 1) {
                WxMsgText text = new WxMsgText();
                text.setContent(contentText);
                text.setMsgForeignKey(currentTime);
                wxMsgIService.insertMsgContentStore(text);
                LOGGER.info("保存信息成功， errcode:{} " + res);
            }*/
            // 下面这部分内容为获取微信服务器发送过来的数据格式
            /*ServletInputStream is = request.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
            System.out.println(sb.toString());*/
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 保存公共的消息, 后面还需要在此方法中判断该用户是否存在, 存在的话使用一个字段来更新消息发送的次数
     * @param map
     *              将用户的XML格式消息转换成Map
     * @return
     *              1 - 成功， other - 失败
     */
    private int saveCommonMsg(Map<String, String> map, String timestrap) {
        String uuid = UUID.randomUUID().toString();
        // Map转换为JavaBean
        WxMsg wxMsg = JSON.parseObject(JSON.toJSONString(map), WxMsg.class);
        // String currentTime = String.valueOf(System.currentTimeMillis());
        wxMsg.setUid(uuid);
        wxMsg.setMsgForeignKey(timestrap);
        wxMsg.setMsgSource(CommEnum.MsgSource.用户.getValue());
        return wxMsgIService.insertMsg(wxMsg);
    }

    /**
     * 使用反射调用实体对象
     * 保存消息内容
     */
    private <T> T saveContentMsg(Class<T> tClass) {
        T obj = null;
        try {
            obj = tClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
