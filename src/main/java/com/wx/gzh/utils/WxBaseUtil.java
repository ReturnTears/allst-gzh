package com.wx.gzh.utils;

import com.wx.gzh.constant.CommEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 工具类中的公共方法
 * @Auther Junn
 * @Date 2019/6/27 0027下午 16:53
 */
public class WxBaseUtil {

    private static final Logger logger = LoggerFactory.getLogger(WxBaseUtil.class);

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
            httpURLConn.setRequestProperty("Charset", CommEnum.EncodingMode.UTF8编码.getValue());
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
            byte[] head = sb.toString().getBytes(CommEnum.EncodingMode.UTF8编码.getValue());

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
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes(CommEnum.EncodingMode.UTF8编码.getValue());
            outputStream.write(foot);
            outputStream.flush();
            outputStream.close();

            // 5、将微信服务器返回的输入流转换成字符串
            InputStream inputStream = httpURLConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, CommEnum.EncodingMode.UTF8编码.getValue());
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
            httpURLConn.disconnect();
        } catch (Exception e) {
            logger.error("发送POST请求出现异常!" + e);
            e.printStackTrace();
        }
        return buffer.toString();
    }

}
