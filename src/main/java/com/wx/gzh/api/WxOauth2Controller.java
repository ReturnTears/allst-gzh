package com.wx.gzh.api;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.constant.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 微信Oauth2.0授权
 * @author JUNN
 * @since 2019-07-10 下午 11:27
 */
@Controller
@RequestMapping("/api/oauth")
public class WxOauth2Controller {

    /**
     * 第一步:用户同意授权，获取Code
     */
    @RequestMapping("code")
    public void oauth(HttpServletResponse response) {

//        String path = Constant.URL + "/ticket";
        String path = "http://huwx.free.idcfengye.com/web/conn/index";
        try {
            path = URLEncoder.encode(path, CommEnum.EncodingMode.UTF8编码.getValue());
        } catch (UnsupportedEncodingException e) {
            System.out.println("编码失败...");
            e.printStackTrace();
        }

        String URL = Constant.WX_OAuth2_Code.replace("APPID",Constant.APPID)
                                        .replace("REDIRECT_URI", path)
                                        .replace("SCOPE", Constant.WX_SNSAPI_USERINFO)
                                .replace("STATE", "YANGYANG");


        try {
            response.sendRedirect(URL);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
     * 域名 + /api/oauth/invoke
     */
    @RequestMapping("invoke")
    public void aouthInvoke(HttpServletRequest request) {
        // 获取Code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        System.out.println("获取的CODE : " + code + " ,state = " + state);
    }
}
