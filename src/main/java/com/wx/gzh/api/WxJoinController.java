package com.wx.gzh.api;

import com.wx.gzh.service.WxJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号的接入
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@RestController
@RequestMapping("/api/join")
public class WxJoinController {

    private static final String TOKEN = "hyj";

    @Autowired
    private WxJoinService wxJoinService;

    /**
     * @param signature	    微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp	    时间戳
     * @param nonce	        随机数
     * @param echostr	    随机字符串
     * @return
     */
    @RequestMapping(value = "wx", method = RequestMethod.GET)
    public String joinWxInterface(@RequestParam("signature") String signature,
                                    @RequestParam("timestamp") String timestamp,
                                    @RequestParam("nonce") String nonce,
                                    @RequestParam("echostr") String echostr) {
        System.out.println("进入到API joinWxInterface方法");
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
        if (wxJoinService.check(timestamp, nonce, signature)) {
            System.out.println("Wx接入成功");
        } else {
            System.out.println("Wx接入失败");
        }
        return echostr;
    }

}
