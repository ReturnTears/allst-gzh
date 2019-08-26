package com.wx.gzh.oauth2;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.constant.Constant;
import com.wx.gzh.utils.CoreToolsUtil;
import com.wx.gzh.utils.WxHttpUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JUNN
 * @since 2019-08-20 下午 08:41
 */
public class WxOauth2Index {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxOauth2Index.class);

    /**
     * 用户授权同意
     * @param redirectUri
     *              回调链接地址
     * @return
     *              授权地址
     */
    public static String oauth2Agree(String redirectUri) {
        String path = "";
        if (CoreToolsUtil.isNotNull(redirectUri)) {
            path = "http://" + redirectUri;
        } else {
            // 默认路径
            path = "http://huwx.free.idcfengye.com/wx/oauth/invoke";
        }
        try {
            path = URLEncoder.encode(path, CommEnum.EncodingMode.UTF8编码.getValue());
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("网页授权编码失败, 失败原因(" + e.getMessage() + ")");
            e.printStackTrace();
        }

        /*
         * APPID: 公众号的唯一标识
         * REDIRECT_URI: 授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
         * SCOPE: 应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息 ）
         * STATE: 重定向后会带上state参数， 非必须
         */
        return Constant.WX_OAuth2_Code.replace("APPID",Constant.APPID)
                                        .replace("REDIRECT_URI", path)
                                        .replace("SCOPE", Constant.WX_SNSAPI_USERINFO)
                                        .replace("STATE", "WXOauth");
    }

    /**
     * 通过code换取网页授权access_token
     * @param Code
     *                  用户授权同意后获取的CODE
     * @return
     *                  通过CODE换取的access_token
     */
    public static Map<String, Object> oauth2CodeExToken(String Code) {
        String oAuth2TokenUrl = Constant.WX_OAuth2_ACCESS_TOKEN.replace("APPID",Constant.APPID)
                                                                .replace("SECRET",Constant.APPSECRET)
                                                                .replace("CODE", Code);
        /*
         *  返回说明
         *  access_token: 网页授权接口调用凭证
         *  expires_in:	access_token接口调用凭证超时时间，单位（秒）
         *  refresh_token: 用户刷新access_token
         *  openid: 用户唯一标识
         *  scope: 用户授权的作用域，使用逗号（,）分隔
         */
        JSONObject jsonObject = WxHttpUtil.httpRequest(oAuth2TokenUrl, "GET", "");
        if (CoreToolsUtil.isNotNull(jsonObject)) {
            Map<String, Object> map = new HashMap<>();
            map.put("accessToken", jsonObject.getString("access_token"));
            map.put("expiresIn", jsonObject.getString("expires_in"));
            map.put("refreshToken", jsonObject.getString("refresh_token"));
            map.put("openId", jsonObject.getString("openid"));
            map.put("scope", jsonObject.getString("scope"));
            return map;
        }
        return null;
    }

    /**
     * 刷新access_token（如果需要）
     * 由于access_token拥有较短的有效期，当access_token超时后，可以使用refresh_token进行刷新，refresh_token有效期为30天，当refresh_token失效之后，需要用户重新授权。
     * @param refreshToken
     *                      用户刷新access_token
     * @return
     *                      通过刷新access_token获取的access_token
     */
    public static String oauth2RefreshToken(String refreshToken) {
        String oauth2Refresh = Constant.WX_OAuth2_REFRESH_TOKEN.replace("APPID", Constant.APPID).replace("REFRESH_TOKEN", refreshToken);
        JSONObject jsonObject = WxHttpUtil.httpRequest(oauth2Refresh, "GET", "");
        if (CoreToolsUtil.isNotNull(jsonObject)) {
            //System.out.println(jsonObject.getString("access_token"));
            return  jsonObject.getString("access_token");
        }
        return null;
    }

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     *      如果网页授权作用域为snsapi_userinfo，则此时开发者可以通过access_token和openid拉取用户信息了。
     * @return
     *              用户信息JSON数据
     */
    public static String oauth2UserInfo(String accessToken, String openId) {
        String oauth2UserInfo = Constant.Wx_OAuth2_USER_INFO.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        JSONObject jsonObject = WxHttpUtil.httpRequest(oauth2UserInfo, "GET", "");
        if (CoreToolsUtil.isNotNull(jsonObject)) {
            //System.out.println("拉去用户信息 : " + jsonObject);
            return String.valueOf(jsonObject);
        }
        return null;
    }
}
