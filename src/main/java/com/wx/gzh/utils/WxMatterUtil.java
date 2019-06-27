package com.wx.gzh.utils;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.constant.Constant;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

/**
 * 素材管理工具类
 * @Auther JUNN
 * @Date 2019-06-26 下午 11:20
 */
public class WxMatterUtil {
    /**
     * 上传临时素材
     * @param path
     *                  上传文件的路径
     * @param type
     *                  上传文件的类型
     * @return
     */
    public static String uploadTempMatter(String path, String type) {
        File file = new File(path);
        String access_token = WxAccessTokenUtils.getAccessToken();
        String matterType = CommEnum.MatterType.图片.getValue();
        // 地址
        String url = Constant.MATTER_ADD_TEMP.replace("ACCESS_TOKEN", access_token).replace("TYPE", type);
        try {
            URL urlObj = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) urlObj.openConnection();
            // 设置连接信息
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            // 设置请求头信息
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", CommEnum.EncodingMode.UTF8编码.getValue());
            // 设置边界
            String boundary = "--" + System.currentTimeMillis();
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            // 获取输出流
            OutputStream out = conn.getOutputStream();
            // 文件输入流
            InputStream in = new FileInputStream(file);
            // 1、头部信息
            StringBuilder builder = new StringBuilder();
            builder.append("--");
            builder.append(boundary);
            builder.append("\r\n");
            builder.append("Content-Disposition;form-data;name=\"media\";filename=\"" + file.getName() + "\"\r\n\r\n");
            builder.append("Content-Type;application/octet-stream\r\n\r\n");
            out.write(builder.toString().getBytes());
            // 2、文件内容
            byte[] b = new byte[1024];
            int len;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            // 3、尾部信息
            String footer = "\r\n--" + boundary + "--\r\n";
            out.write(footer.getBytes());
            out.flush();
            out.close();
            // 读取数据
            InputStream is = conn.getInputStream();
            StringBuilder sb = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}
