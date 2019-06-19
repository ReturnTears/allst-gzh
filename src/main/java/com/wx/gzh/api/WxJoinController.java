package com.wx.gzh.api;

import com.wx.gzh.service.WxAcceptMsgService;
import com.wx.gzh.service.WxHandlerEventMsgService;
import com.wx.gzh.service.WxJoinService;
import com.wx.gzh.utils.WxTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 微信公众号的接入, 改用RESTful的编码方式
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@RestController
@RequestMapping("/api/join")
public class WxJoinController {

    private static final String TOKEN = "hyj";

    private static final String RESPMSG = "消息收到回复";

    @Autowired
    private WxJoinService wxJoinService;

    @Autowired
    private WxAcceptMsgService wxAcceptMsgService;

    @Autowired
    private WxHandlerEventMsgService wxHandlerEventMsgService;

    /**
     * @param signature	    微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp	    时间戳
     * @param nonce	        随机数
     * @param echostr	    随机字符串
     * @return
     */
    // @RequestMapping(value = "wx", method = RequestMethod.GET)
    @GetMapping
    public String joinWxInterface(@RequestParam("signature") String signature,
                                    @RequestParam("timestamp") String timestamp,
                                    @RequestParam("nonce") String nonce,
                                    @RequestParam("echostr") String echostr) {
        System.out.println("进入到API joinWxInterface方法");
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
        if (wxJoinService.check(timestamp, nonce, signature)) {
            System.out.println("Wx接入成功");
        } else {
            System.out.println("Wx接入失败");
        }
        return echostr;
    }

    /**
     * 接受消息
     * @param request
     * @param response
     * @return
     */
    // @RequestMapping(value = "msg", method = RequestMethod.POST)
    @PostMapping
    public String getWxAcceptMsg(HttpServletRequest request, HttpServletResponse response) {
        // 接受用户消息
        System.out.println("接受用户发送的消息");
        Map<String, String> res = wxAcceptMsgService.joinWxMsg(request, response);
        // 被动回复用户消息,准备回复的数据包
        /*String resXml = "<xml><ToUserName><![CDATA["+ res.get("FromUserName") +"]]></ToUserName>" +
                            "<FromUserName><![CDATA[" + res.get("ToUserName") + "]]></FromUserName>" +
                            "<CreateTime>" + System.currentTimeMillis() / 1000 + "</CreateTime>" +
                            "<MsgType><![CDATA[text]]></MsgType>" +
                            "<Content><![CDATA[" + RESPMSG + "]]></Content></xml>";
        System.out.println(resXml);*/

        // 消息的统一处理
        String textMessage = wxHandlerEventMsgService.handlerEventAndMsg(res);
        System.out.println("Text消息 : " + textMessage);
        return null;
    }
}
