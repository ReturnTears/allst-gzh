package com.wx.gzh.api;

import com.wx.gzh.service.WxAcceptMsgIService;
import com.wx.gzh.service.WxHandlerMsgIService;
import com.wx.gzh.service.WxJointIService;
import com.wx.gzh.utils.JsonResult;
import com.wx.gzh.utils.WxQRCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 微信公众号的接入入口
 * @author Junn
 * @since 2019/6/19 0019
 */
@RestController
@RequestMapping("/api/join")
public class WxJointController {

    private static final Logger logger = LoggerFactory.getLogger(WxJointController.class);

    @Autowired
    private WxJointIService wxJoinService;

    @Autowired
    private WxAcceptMsgIService wxAcceptMsgIService;

    @Autowired
    private WxHandlerMsgIService wxHandlerMsgService;

    /**
     * @param signature	    微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp	    时间戳
     * @param nonce	        随机数
     * @param echostr	    随机字符串
     * @return
     *              返回接入信息
     */
    @RequestMapping(value = "wx", method = RequestMethod.GET)
    //@GetMapping
    public JsonResult joinWxInterface(@RequestParam("signature") String signature,
                                    @RequestParam("timestamp") String timestamp,
                                    @RequestParam("nonce") String nonce,
                                    @RequestParam("echostr") String echostr) {
        System.out.println(String.format("Wx接入参数:signature=%s,timestamp=%s,nonce=%s,echostr=%s", signature, timestamp, nonce, echostr));
        if (wxJoinService.check(timestamp, nonce, signature)) {
            logger.info("WeiXin接入成功");
            return new JsonResult(true, "WeiXin接入成功");
        } else {
            logger.error("WeiXin接入失败");
            return new JsonResult(false, "WeiXin接入失败");
        }
    }

    /**
     * 接受消息以及回复消息
     * @param request
     *                  HttpServletRequest
     * @param response
     *                  HttpServletResponse
     * @return
     *                  回复的消息内容
     */
    // @RequestMapping(value = "msg", method = RequestMethod.POST)
    @PostMapping
    public String getWxAcceptMsg(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> res = wxAcceptMsgIService.joinWxMsg(request, response);

        // 消息的统一处理, 需要将回复的消息封装为上述格式的xml内容
        String textXml = wxHandlerMsgService.replayMsgs(res);
        System.out.println("回复消息 >> : " + textXml);
        return textXml;
    }

    @PostMapping("reply")
    public String replyPushMsg() {
        String textXml = wxHandlerMsgService.pushMsg();
        System.out.println("textXml : " + textXml);
        return textXml;
    }

    @GetMapping("ticket")
    public String getQRCodeTicket(HttpServletRequest request, HttpServletResponse response) {

        String ticket = WxQRCodeUtil.getQrCodeTempTicket();
        return ticket;
    }
}
