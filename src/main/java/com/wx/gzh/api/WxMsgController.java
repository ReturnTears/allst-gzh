package com.wx.gzh.api;

import com.wx.gzh.service.WxAcceptMsgIService;
import com.wx.gzh.service.WxMsgIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "acceptMsg", method = RequestMethod.GET)
    public String getWxAcceptMsg(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("accept msg");
        Map<String, String> res = wxMsgIService.joinWxMsg(request, response);
        System.out.println("res" + res);
        return null;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "temp", method = RequestMethod.POST)
    public String sendWxTemplateMsg(HttpServletRequest request) {
        boolean flag = wxMsgIService.sendMessage("o_Ag01ZEmXLI2gCkgSaCmn6FYbmI", "模板测试", "aaa", "bbbb", request);
        if (flag) {
            return "success";
        }
        return "Failure";
    }
}
