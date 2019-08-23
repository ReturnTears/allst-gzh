package com.wx.gzh.api;

import com.wx.gzh.model.WxMsgTemplate;
import com.wx.gzh.model.WxTemplateData;
import com.wx.gzh.service.WxMsgIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接收消息，发送消息Controller
 * @author Junn
 * @since 2019/6/19 0019
 */
@Controller
@RequestMapping("/wx/msg")
public class WxMsgController {

    @Autowired
    private WxMsgIService wxMsgIService;

    @RequestMapping(value = "accept", method = RequestMethod.GET)
    public String getWxAcceptMsg(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("accept msg");
        Map<String, String> res = wxMsgIService.joinWxMsg(request, response);
        System.out.println("res" + res);
        return null;
    }

    /**
     * 发送目标那消息
     * @return
     *          成功返回Success， 失败返回Failure
     */
    @ResponseBody
    @RequestMapping(value = "temp", method = RequestMethod.GET)
    public String sendWxTemplateMsg(HttpServletRequest request) {
        /**
         * {{first.DATA}} 通知时间:{{time.DATA}} 通知内容:{{content.DATA}} {{remark.DATA}}
         */
        Map<String, Object> parmas = new HashMap<>();
        parmas.put("templateId", "FEbG1tlcb0vQAEE3l4OfXuTyNXqv4fZay6nH7QnHGk4");
        parmas.put("color", "#173177");
        parmas.put("toUser", "o_Ag01ZEmXLI2gCkgSaCmn6FYbmI");
        parmas.put("url", "https://www.baidu.com/");

        boolean flag = wxMsgIService.sendTempMessage(parmas);
        if (flag) {
            return "Success";
        }
        return "Failure";
    }

    @ResponseBody
    @RequestMapping(value = "push", method = RequestMethod.GET)
    public String sendPushMsg() {
        return "";
    }
}
