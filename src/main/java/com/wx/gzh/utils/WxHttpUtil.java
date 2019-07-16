package com.wx.gzh.utils;

import com.wx.gzh.constant.CommEnum;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Http工具类
 * @Auther JUNN
 * @Date 2019-07-16 下午 10:48
 */
public class WxHttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(WxHttpUtil.class);
    /**
     * 方式1，推荐使用方式2--> httpRequest
     * 发送POST请求返回JSON对象结果
     * @param requestURL
     *                      微信公众号菜单创建HTTPS接口
     * @param outPutStr
     *                      返回结果
     * @return
     */
    public static JSONObject doPostStr(String requestURL, String outPutStr) {
        JSONObject jsonObject = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(requestURL);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);
            // 设置请求方式（GET/POST）
            urlConnection.setRequestMethod(CommEnum.RequestMode.POST请求.getValue());

            if (outPutStr != null) {
                OutputStream outputStream = urlConnection.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outPutStr.getBytes(StandardCharsets.UTF_8 ));
                outputStream.close();
            }

            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8 );
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String res = null;
            while ((res = bufferedReader.readLine()) != null) {
                builder.append(res);
            }
            inputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
            urlConnection.disconnect();
            return JSONObject.fromObject(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
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
            logger.error("Weixin server connection timed out.");
        } catch (Exception e) {
            logger.error("https request error:{}", e);
        }
        return jsonObject;
    }
}
