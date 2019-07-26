package com.wx.gzh.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微信前台管理Index Controller
 * @author JUNN
 * @since 2019/7/26 0026下午 14:18
 */
@Controller
@RequestMapping("/web/front")
public class FrontIndexController {

    @RequestMapping("/index")
    public String showFrontIndex() {
        return "front/frontIndex";
    }

    /**
     * 显示公司简介(Vue方式)
     * @return
     */
    @RequestMapping("/profile")
    public String showCpyProfile() {
        return "front/menu/companyProfile";
    }

    /**
     * 显示公司简介(H5方式)
     * @return
     */
    @RequestMapping("/profile5")
    public String showCpyProfileH5() {
        return "front/menu/cpyProfile";
    }
}
