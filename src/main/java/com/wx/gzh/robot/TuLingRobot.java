package com.wx.gzh.robot;

import com.wx.gzh.constant.TuiLingConstant;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Scanner;

/**
 * 图灵机器人
 * @Auther JUNN
 * @Date 2019-06-21 下午 11:50
 */
public class TuLingRobot {

    /**
     * 获取请求参数的JSON字符串
     * {
     * 	   "reqType":0,
     *     "perception": {
     *         "inputText": {
     *             "text": "附近的酒店"
     *         },
     *         "inputImage": {
     *             "url": "imageUrl"
     *         },
     *         "selfInfo": {
     *             "location": {
     *                 "city": "北京",
     *                 "province": "北京",
     *                 "street": "信息路"
     *             }
     *         }
     *     },
     *     "userInfo": {
     *         "apiKey": "6ad46dd0a00a400282a8d70b2b0faba9",
     *         "userId": "469240"
     *     }
     * }
     * @param params
     * @return
     */
    public static String getRequestParams(String params) {
        JSONObject jsonObject = new JSONObject();
        // 输入类型:0-文本(默认)、1-图片、2-音频(非必输)
        int reqType = 0;
        jsonObject.put("reqType", reqType);
        JSONObject perception = new JSONObject();
        JSONObject inputText = new JSONObject();
        inputText.put("text", params);
        perception.put("inputText", inputText);

        // 输入图片信息
        /*JSONObject inputImage = new JSONObject();
        inputImage.put("url", "");
        perception.put("inputImage", inputImage);*/

        // 个人信息
        /*JSONObject selfInfo = new JSONObject();
        JSONObject location = new JSONObject();
        location.put("city", "");
        location.put("province", "");
        location.put("street", "");
        selfInfo.put("location", location);
        perception.put("selfInfo", selfInfo);*/

        // 用户信息
        JSONObject userInfo = new JSONObject();
        userInfo.put("apiKey", TuiLingConstant.APIKEY);
        userInfo.put("userId", TuiLingConstant.USERID);

        jsonObject.put("perception", perception);
        jsonObject.put("userInfo", userInfo);

        return jsonObject.toString();
    }

    public static String tulinPost(String url, String reqMes) {
        String status = "";
        String responseStr = "";
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 建立连接
            URLConnection conn = realUrl.openConnection();
            HttpURLConnection httpUrl = (HttpURLConnection) conn;
            // 设置请求属性
            httpUrl.setRequestProperty("Content-Type", "application/json");
            httpUrl.setRequestProperty("x-adviewrtb-version", "2.1");
            // 发送POST请求必须设置如下两行
            httpUrl.setDoInput(true);
            httpUrl.setDoOutput(true);
            // 获取流
            out = new PrintWriter(httpUrl.getOutputStream());
            // 发送请求参数
            out.write(reqMes);
            // flush
            out.flush();
            httpUrl.connect();
            in = new BufferedReader(new InputStreamReader(httpUrl.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                responseStr += line;
            }
            /*status = new Integer(httpUrl.getResponseCode()).toString();
            System.out.println("status = " + status);
            System.out.println("response = " + responseStr);*/
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseStr;
    }

    /**
     * 解析返回内容， 回去机器人回复的文本
     * @param tuilinPostStr
     * @return
     */
    public static String getResultMes(String tuilinPostStr) {
        JSONObject theRes = JSONObject.fromObject(tuilinPostStr);
        List<Object> results = (List<Object>) theRes.get("results");
        JSONObject resultObj = JSONObject.fromObject(results.get(0));
        JSONObject values = JSONObject.fromObject(resultObj.get("values"));
        return values.get("text").toString();
    }

    /**
     * 测试图灵机器人
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("输入：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String reqStr = getRequestParams(scanner.next());
            String respStr = tulinPost(TuiLingConstant.APIURL, reqStr);
            String talk = getResultMes(respStr);
            System.out.println("TA > 你说 : " + talk);
        }
    }
}
