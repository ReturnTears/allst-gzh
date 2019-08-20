package com.wx.gzh.api;

import com.wx.gzh.service.WxAcceptMsgIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 非RESTful方式
 * @author Junn
 * @since 2019/6/19 0019
 */
@Controller
@RequestMapping("/api/accept")
public class WxAcceptMsgController {

    @Autowired
    private WxAcceptMsgIService wxAcceptMsgIService;

    @RequestMapping(value = "msg", method = RequestMethod.POST)
    public String getWxAcceptMsg(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("accept msg");
        Map<String, String> res = wxAcceptMsgIService.joinWxMsg(request, response);
        return null;
    }
}
