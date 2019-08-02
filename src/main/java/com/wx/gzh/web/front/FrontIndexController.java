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
     * @return page
     */
    @RequestMapping("/profileV")
    public String showCpyProfile() {
        return "front/menu/comp";
    }

    /**
     * 显示公司简介(H5方式)
     * @return page
     */
    @RequestMapping("/comp")
    public String showCpyProfileH5() {
        return "front/menu/comp";
    }

    /**
     * 显示项目案例(H5方式)
     * @return  page
     */
    @RequestMapping("/proj")
    public String showProject() {
        return "front/menu/proj";
    }

    /**
     * 显示人才招聘(H5方式)
     * @return page
     */
    @RequestMapping("/jobs")
    public String showJobs() {
        return "front/menu/jobs";
    }

}
