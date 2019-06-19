package com.wx.gzh.api;

import com.wx.gzh.service.WxAcceptMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 非RESTful方式
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@Controller
@RequestMapping("/api/accept")
public class WxAcceptMsgController {

    @Autowired
    private WxAcceptMsgService wxAcceptMsgService;

    @RequestMapping(value = "msg", method = RequestMethod.POST)
    public String getWxAcceptMsg(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("accept msg");
        String res = wxAcceptMsgService.joinWxMsg(request, response);
        return res;
    }
}
