package com.wx.gzh.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Index Controller
 * @author JUNN
 * @since 2019/6/14
 */
@Controller
@RequestMapping("/web/conn")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("index")
    public ModelAndView webIndex() {
        ModelAndView view = new ModelAndView();
        view.addObject("ticket", "");
        view.setViewName("index");
        return view;
    }

    @RequestMapping(value = "inde", method = {RequestMethod.POST, RequestMethod.GET})
    public String index() {
        logger.info("Come in WebController index method");
        return "index";
    }
}
