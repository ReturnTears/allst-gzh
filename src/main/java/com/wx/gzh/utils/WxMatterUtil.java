package com.wx.gzh.utils;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.constant.Constant;
import net.sf.json.JSONObject;
import org.apache.tomcat.jni.SSL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
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
    public static String addTempMatter(String path, String type) {
        StringBuffer buffer = new StringBuffer();
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            try {
                throw new IOException("文件不存在！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 获取Access_Token
        String access_token = WxAccessTokenUtils.getAccessToken();
        String matterType = CommEnum.MatterType.图片.getValue();
        // 地址
        String url = Constant.MATTER_ADD_TEMP.replace("ACCESS_TOKEN", access_token).replace("TYPE", type);
        System.out.println("新增素材时的url : " + url);
        try {
            URL urlObj = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) urlObj.openConnection();
            // 设置连接信息
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(CommEnum.RequestMode.POST请求.getValue());
            // 设置请求头信息
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", CommEnum.EncodingMode.UTF8编码.getValue());
            // 设置边界
            String boundary = "----------" + System.currentTimeMillis();
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            // 获取输出流
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // 文件输入流
            InputStream in = new DataInputStream(new FileInputStream(file));
            // 1、头部信息
            StringBuilder builder = new StringBuilder();
            builder.append("--");
            builder.append(boundary);
            builder.append("\r\n");
            builder.append("Content-Disposition:form-data;name=\"media\";filename=\"" + file.getName() + "\";filelength=\"" + file.length() + "\"\r\n\r\n");
            builder.append("Content-Type:application/octet-stream\r\n\r\n");
            out.write(builder.toString().getBytes(CommEnum.EncodingMode.UTF8编码.getValue()));
            // 2、文件内容
            byte[] b = new byte[1024 * 1024 * 10];
            int len;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            in.close();
            // 3、尾部信息
            byte[] footer = ("\r\n--" + boundary + "--\r\n").getBytes(CommEnum.EncodingMode.UTF8编码.getValue());
            out.write(footer);
            out.flush();
            out.close();

            // 读取数据, 获取响应
            // StringBuffer buffer = new StringBuffer();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
            conn.disconnect();
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static JSONObject uploadTempMaterial() {
        String accessToken = WxAccessTokenUtils.getAccessToken();
        System.out.println("accesstoken : " + accessToken);
        String type = CommEnum.MatterType.图片.getValue();
        String fileUrl = "C:\\Users\\Administrator\\Pictures\\111.PNG";
        // 1、创建本地文件
        File file = new File(fileUrl);
        // 2、拼接请求URL
        String URL = Constant.MATTER_ADD_TEMP.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
        // 3、调用接口，发送请求，上传文件到微信服务器
        String result = WxBaseUtil.httpRequest(URL, file);
        // 4、json字符串转对象，解析返回值，json反序列化
        result = result.replaceAll("[\\\\]]", "");
        System.out.println("result : " + result);
        JSONObject resultJson = JSONObject.fromObject(result);
        // 5、返回参数判断
        if (resultJson != null) {
            if (resultJson.get("media_id") != null) {
                System.out.println("上传" + type + "永久素材成功");
                return resultJson;
            } else {
                System.out.println("上传" + type + "永久素材失败");
            }
        }
        return null;
    }

    /**
     * 下载临时文件
     * @param media_id
     *                  mediaId
     * @return
     */
    public static String downloadTempMatter(String media_id) {
        return null;
    }

    /**
     * 新增永久文件
     * @return
     */
    public static String addPermMatter() {
        return null;
    }

}
