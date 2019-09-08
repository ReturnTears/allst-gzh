package com.wx.gzh.api;

import com.wx.gzh.oauth2.WxOauth2Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 微信Oauth2.0授权
 * @author JUNN
 * @since 2019-07-10 下午 11:27
 */
@RestController
@RequestMapping("/wx/oauth")
public class WxOauth2Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxOauth2Controller.class);

    /**
     * 第一步:用户同意授权，获取Code
     * @param response
     *                  HttpServletResponse
     */
    @RequestMapping("code")
    public void oauth(@RequestParam String redirectUri, HttpServletResponse response) {
        String URL = WxOauth2Index.oauth2Agree(redirectUri);
        try {
            response.sendRedirect(URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第二步:
     * 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
     * 域名 + /wx/oauth/invoke
     * 获取Code, 通过code换取网页授权access_token
     * @param request
     *                  HttpServletRequest
     */
    @GetMapping("invoke")
    public void oauthInvoke(HttpServletRequest request) {
        // 获取Code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        Map<String, Object> access_token = WxOauth2Index.oauth2CodeExToken(code);
        System.out.println("通过CODE获取的access_token : " + access_token.get("accessToken"));

        /*String refreshToken = WxOauth2Index.oauth2RefreshToken(access_token.get("refreshToken").toString());
        System.out.println("通过refresh_token获取access_token : " + refreshToken);*/

        String at = access_token.get("accessToken").toString();
        String id = access_token.get("openId").toString();
        // 拉取用户信息
        WxOauth2Index.oauth2UserInfo(at, id);
    }

}
