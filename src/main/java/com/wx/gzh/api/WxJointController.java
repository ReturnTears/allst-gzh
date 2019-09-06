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
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 微信公众号的接入入口   /api/join
 * @author Junn
 * @since 2019/6/19 0019
 */
@RestController
@RequestMapping("/wx/api")
public class WxJointController {

    private static final Logger logger = LoggerFactory.getLogger(WxJointController.class);

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

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
    //@RequestMapping(value = "/join", method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("wx")
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

   /* @RequestMapping(value="join",method=RequestMethod.GET)
    @ResponseBody*/
    public void getWeiXinMethod(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean validate = validate(request);
        if (validate) {
            response.getWriter().write(request.getParameter("echostr"));
            response.getWriter().close();
        }
    }

    private boolean validate(HttpServletRequest req) throws IOException {
        String signature = req.getParameter("signature");//微信加密签名
        String timestamp = req.getParameter("timestamp");//时间戳
        String nonce = req.getParameter("nonce");//随机数
        System.out.println(String.format("Wx接入参数:signature=%s,timestamp=%s,nonce=%s", signature, timestamp, nonce));
        List<String> list = new ArrayList<>();
        list.add("puskeR");
        list.add(timestamp);
        list.add(nonce);
        Collections.sort(list);//字典排序
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s += (String) list.get(i);
        }
        if (encode("SHA1", s).equalsIgnoreCase(signature)) {
            return true;
        } else {
            return false;
        }
    }

    public static String encode(String algorithm, String str) {
        if (str == null) {
            return null;
        }
        try {
            //Java自带的加密类
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            //转为byte
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
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

    /*@PostMapping("reply")
    public String replyPushMsg() {
        String textXml = wxHandlerMsgService.pushMsg();
        System.out.println("textXml : " + textXml);
        return textXml;
    }

    @GetMapping("ticket")
    public String getQRCodeTicket(HttpServletRequest request, HttpServletResponse response) {

        String ticket = WxQRCodeUtil.getQrCodeTempTicket();
        return ticket;
    }*/
}
