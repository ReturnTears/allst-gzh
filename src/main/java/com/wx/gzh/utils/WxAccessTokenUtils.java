package com.wx.gzh.utils;

import com.wx.gzh.constant.Constant;
import com.wx.gzh.entity.token.AccessToken;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static com.wx.gzh.constant.Constant.APPID;
import static com.wx.gzh.constant.Constant.APPSECRET;

/**
 * access_token是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token。
 * 微信AccessToken工具类
 * @author JUNN
 * @since 2019/6/24 0024下午 14:55
 */
public class WxAccessTokenUtils {

    public static void main(String[] args) {
        getToken();
    }

    private static Logger log = LoggerFactory.getLogger(WxAccessTokenUtils.class);
    /**
     * 声明一个token对象
     */
    private static AccessToken token;
    /**
     * 获取ACCESS_TOKEN
     * @param appid
     *                      凭证
     * @param appsecret
     *                      密钥
     * @return
     */
    public static AccessToken getAccessToken(String appid, String appsecret) {
        AccessToken accessToken = null;

        String requestUrl = Constant.ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
        JSONObject jsonObject = WxHttpUtil.httpRequest(requestUrl, "GET", null);
        System.out.println("-------------------------" + jsonObject.toString());
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setAccess_token(jsonObject.getString("access_token"));
                accessToken.setExpires_in(jsonObject.getInt("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败
                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }




    /**
     * 获取
     * @return
     */
    public static String getAccessToken() {
        if (token == null || token.isExpired()) {
            getToken();
        }
        return token.getAccess_token();
    }

    /**
     * 通过APPID和APPSECRET获取AccessToken，并存储起来
     * {
     *    "access_token":"22_Yq7sMrhkkr0FHcWQA11pZQVPTJ5zTgZMxkaezmDhOby03_PQVsFtaD46VOsoTr4sk8z4vG1UU3v2j_EOdZ4dkPZ31qSff4R4sO_jAVMq3XIQtBmDrHulcmsp5L0qttn-0A564OGv4Dkb7Et7CQRiADATHI",
     *    "expires_in":7200
     * }
     */
    public static void getToken(){
        String url = Constant.ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        String tokenStr = WxAccessTokenUtils.getOrPost(url);
        System.out.println("token : " + tokenStr);
        JSONObject jsonObject = JSONObject.fromObject(tokenStr);
        String accessToken = jsonObject.getString("access_token");
        String expiresIn = jsonObject.getString("expires_in");
        // 创建token对象，并存起来
        token = new AccessToken(accessToken, expiresIn);
        System.out.println(token);
    }

    /**
     * 向指定的地址发送Get请求
     * @param url
     *               指定URL
     * @return
     */
    private static String getOrPost(String url) {
        try {
            URL urlObj = new URL(url);
            // 打开链接
            URLConnection connection = urlObj.openConnection();
            InputStream is = connection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder builder = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                builder.append(new String(b, 0, len));
            }
            return builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
