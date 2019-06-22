package com.wx.gzh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther Junn
 * @Date 2019/6/14 0014
 */
@Controller
@RequestMapping("/web/conn")
public class WebController {

    @RequestMapping("index")
    public ModelAndView webIndex() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }

    @RequestMapping(value = "inde", method = {RequestMethod.POST, RequestMethod.GET})
    public String index() {
        return "index";
    }
}
