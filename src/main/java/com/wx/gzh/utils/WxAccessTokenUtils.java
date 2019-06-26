package com.wx.gzh.utils;

import com.wx.gzh.constant.Constant;
import com.wx.gzh.model.AccessToken;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import static com.wx.gzh.constant.Constant.APPID;
import static com.wx.gzh.constant.Constant.APPSECRET;

/**
 * access_token是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token。
 * 微信AccessToken工具类
 * @Auther Junn
 * @Date 2019/6/24 0024下午 14:55
 */
public class WxAccessTokenUtils {

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
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
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
     * 方式2
     * 发起https请求并获取结果
     * @param requestURL
     *                          请求地址
     * @param requestMethod
     *                          请求方式(GET / POST)
     * @param outPutStr
     *                          返回结果
     * @return
     */
    public static JSONObject httpRequest(String requestURL, String requestMethod, String outPutStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new WxX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestURL);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }
            // 当有数据需要提交时
            if (null != outPutStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outPutStr.getBytes(StandardCharsets.UTF_8 ));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8 );
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
            System.out.println("返回结果 : " + jsonObject);
        } catch (ConnectException ce) {
            log.error("Weixin server connection timed out.");
        } catch (Exception e) {
            log.error("https request error:{}", e);
        }
        return jsonObject;
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
        JSONObject jsonObject = JSONObject.fromObject(tokenStr);
        String accessToken = jsonObject.getString("access_token");
        String expiresIn = jsonObject.getString("expires_in");
        // 创建token对象，并存起来
        token = new AccessToken(accessToken, expiresIn);
        // System.out.println(token);
    }

    /**
     * 向指定的地址发送Get请求
     * @param url
     *               指定URL
     * @return
     */
    public static String getOrPost(String url) {
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