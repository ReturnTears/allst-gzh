package com.wx.gzh.utils;

import com.wx.gzh.constant.CommEnum;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Http工具类
 * @author JUNN
 * @since 2019-07-16 下午 10:48
 */
public class WxHttpUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxHttpUtil.class);
    /**
     * 方式1，推荐使用方式2--> httpRequest
     * 发送POST请求返回JSON对象结果
     * @param requestURL
     *                      微信公众号菜单创建HTTPS接口
     * @param outPutStr
     *                      返回结果
     * @return              JSON对象
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
            if (CoreToolsUtil.isNotNull(outPutStr)) {
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
            httpUrlConn.disconnect();
            return JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            LOGGER.error("Weixin server connection timed out.");
        } catch (Exception e) {
            LOGGER.error("https request error:{}", e);
        }
        return null;
    }

    /**
     * 微信上传素材的请求方法
     * @param requestUrl
     *                      微信上传临时素材的接口URL
     * @param file
     *                      要上传的文件
     * @return
     *                      上传成功后，微信服务器返回的消息
     */
    public static String httpRequest(String requestUrl, File file) {
        StringBuffer buffer = new StringBuffer();
        try {
            // 1、建立连接
            URL url = new URL(requestUrl);
            HttpURLConnection httpURLConn = (HttpURLConnection) url.openConnection();
            // 输入输出设置
            httpURLConn.setDoInput(true);
            httpURLConn.setDoOutput(true);
            // POST方式不能使用缓存
            httpURLConn.setUseCaches(false);
            // 设置请求头消息
            httpURLConn.setRequestProperty("Connection", "Keep-Alive");
            httpURLConn.setRequestProperty("Charset", CommEnum.EncodingMode.UTF8.getValue());
            // 设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            httpURLConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);

            // 2、请求正文信息， 将文件头输出到微信服务器
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition:form-data;name=\"media\";filelength=\""+file.length()
                    + "\";filename=\"" + file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes(CommEnum.EncodingMode.UTF8.getValue());

            // 获得输出流
            OutputStream outputStream = new DataOutputStream(httpURLConn.getOutputStream());
            // 将表头写入输出流中， 输出表头
            outputStream.write(head);

            // 3、将文件正文部分输出到微信服务器
            // 把文件以流文件的方式写入微信服务器
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                outputStream.write(bufferOut, 0, bytes);
            }
            in.close();
            // 4、将结尾部分输出到微信服务器
            // 定义最后数据分割线
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes(CommEnum.EncodingMode.UTF8.getValue());
            outputStream.write(foot);
            outputStream.flush();
            outputStream.close();

            // 5、将微信服务器返回的输入流转换成字符串
            InputStream inputStream = httpURLConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, CommEnum.EncodingMode.UTF8.getValue());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();

            // 释放资源
            inputStream.close();
            httpURLConn.disconnect();
        } catch (Exception e) {
            LOGGER.error("发送POST请求出现异常!" + e);
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
