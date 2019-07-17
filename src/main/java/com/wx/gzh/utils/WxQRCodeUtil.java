package com.wx.gzh.utils;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.constant.Constant;
import com.wx.gzh.model.URLTools;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 微信二维码工具类
 * @Auther Junn
 * @Date 2019/6/25 0025下午 17:28
 */
public class WxQRCodeUtil {
    /**
     * 获取带参数的临时二维码TICKET
     * @return
     */
    public static String getQrCodeTempTicket() {
        // 获取ACCESSTOKEN
        String accessToken = WxAccessTokenUtils.getAccessToken();
        String url = Constant.WX_QRCODE_URL.replace("TOKEN", accessToken);
        // 生成临时字符二维码POST数据
        String jsonTempData = "{\"expire_seconds\": 600, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"test\"}}}";
        JSONObject object = WxHttpUtil.doPostStr(url, jsonTempData);
        // System.out.println(object);
        String ticket = object.getString("ticket");
        // System.out.println("获取的ticket为 : " + ticket);
        return ticket;
    }

    /**
     * 获取带参数的永久二维码TICKET
     * @return
     */
    public static String getQrCodePermTicket() {
        // 获取ACCESSTOKEN
        String accessToken = WxAccessTokenUtils.getAccessToken();
        String url = Constant.WX_QRCODE_URL.replace("TOKEN", accessToken);
        // 生成永久字符串二维码POST数据
        String jsonPermData= "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"test\"}}}";
        JSONObject object = WxHttpUtil.doPostStr(url, jsonPermData);
        String ticket = object.getString("ticket");
        System.out.println("perm ticket : " + ticket);
        getQrCode(ticket);
        return ticket;
    }

    /**
     * 通过TICKET生成微信二维码
     * @param ticket
     *                      微信生成的TICKET
     * @param qrCodePath
     *                      指定存放的路径
     */
    public static void getQrCode(String ticket, String qrCodePath) {
        qrcode(ticket, qrCodePath);
    }

    /**
     * 通过ticket获取微信二维码
     * @param ticket
     *                  微信生成的TICKET
     */
    public static void getQrCode(String ticket) {
        qrcode(ticket);
    }

    /**
     * 通过TICKET获取二维码并保存
     * @param tickets
     *                  传值的顺序:参数1 -TICKET(必填项), 参数2 - 指定二维码存放的路径， 参数3 - 其他
     */
    private static void qrcode(String... tickets) {
        if (tickets.length > 0) {
            String ticket = tickets[0];
            // 二维码存放路径+二维码名称
            String path = "";
            try {
                String wxTicketUrl = Constant.WX_TICKET_URL.replace("TICKET", URLTools.encodeUTF8Url(ticket));
                URL url = new URL(wxTicketUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setRequestMethod(CommEnum.RequestMode.GET请求.getValue());
                if (tickets.length > 1) {
                    path = tickets[1].endsWith("/") ? (tickets[1] + ticket + ".jpg") : (tickets[1] + "/" + ticket + ".jpg");
                } else {
                    // 如不传递指定存放路径, 将二维码存放到系统默认TEMP目录下
                    path = Constant.TMPDIR + ticket + ".jpg";
                }
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                FileOutputStream fos = new FileOutputStream(new File(path));
                byte[] b = new byte[8096];
                int size = 0;
                while ((size = bis.read(b)) != -1) {
                    fos.write(b, 0, size);
                }
                bis.close();
                fos.close();
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 扫描二维码事件 : 获取用户信息
     *                          获取已经关注了公众号的用户信息
     *                          获取未关注公众号的用户信息
     */
    public static JSONObject scanQRCode() {
        String ACCESS_TIKEN = WxAccessTokenUtils.getAccessToken();
        String OPENID = "o_Ag01ZEmXLI2gCkgSaCmn6FYbmI";
        String wxUserUrl = Constant.WX_USER_URL.replace("ACCESS_TOKEN", ACCESS_TIKEN).replace("OPENID", OPENID);
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(wxUserUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(CommEnum.RequestMode.GET请求.getValue());
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String str = null;
            while ((str = br.readLine()) != null) {
                buffer.append(str);
            }
            conn.disconnect();
            isr.close();
            br.close();
            JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
             System.out.println("获取的JSON对象 : " + jsonObject);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
