package com.wx.gzh.web.end;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微信后台管理Index Controller
 * @author JUNN
 * @since 2019/7/26 0026下午 14:18
 */
@Controller
@RequestMapping(("/web/end"))
public class EndIndexController {

    @RequestMapping("/index")
    public String showEndIndex() {
        return "end/endIndex";
    }

}
