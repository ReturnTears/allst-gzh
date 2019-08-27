package com.wx.gzh.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆/注册
 * @author JUNN
 * @since 2019/8/27 0027 上午 9:41
 */
@Controller
@RequestMapping("/web/wx")
public class LoginController {

    @RequestMapping("login")
    public String login() {
        return "front/login/login";
    }

}
