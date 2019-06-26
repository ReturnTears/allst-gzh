package com.wx.gzh.utils;

import com.wx.gzh.constant.Constant;
import com.wx.gzh.model.Button;
import com.wx.gzh.model.ClickButton;
import com.wx.gzh.model.Menu;
import com.wx.gzh.model.ViewButton;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.wx.gzh.utils.WxAccessTokenUtils.httpRequest;

/**
 * WeiXinUtil工具类
 * @Auther Junn
 * @Date 2019/6/25 0025下午 14:51
 */
public class WeiXinUtil {
    /**
     * 组装菜单
     * @return
     */
    public static Menu initMenu() {
        Menu menu = new Menu();

        ClickButton button11 = new ClickButton();
        button11.setName("公司简介");
        button11.setType("click");
        button11.setKey("11");

        ClickButton button12 = new ClickButton();
        button12.setName("项目案例");
        button12.setType("click");
        button12.setKey("12");

        ClickButton button13 = new ClickButton();
        button13.setName("其他");
        button13.setType("click");
        button13.setKey("13");

        ViewButton button21 = new ViewButton();
        button21.setName("进入项目");
        button21.setType("view");
        button21.setUrl("http://47.101.154.109:9999/admin/web/login");

        ViewButton button22 = new ViewButton();
        button22.setName("图标预览");
        button22.setType("view");
        button22.setUrl("http://47.101.154.109:10004/screen/mobile/pages/index");

        ViewButton button23 = new ViewButton();
        button23.setName("APP下载");
        button23.setType("view");
        button23.setUrl("http://47.101.154.109:10001/mobile/api/app/appUpgradeInfo/downloadApk?newVersion=19");

        ViewButton button24 = new ViewButton();
        button24.setName("其他");
        button24.setType("view");
        button24.setUrl("https://www.baidu.com");

        Button button1 = new Button();
        button1.setName("菜单一");
        button1.setSub_button(new Button[]{button11, button12, button13});

        Button button2 = new Button();
        button2.setName("菜单二");
        button2.setSub_button(new Button[]{button21, button22, button23, button24});

        menu.setButton(new Button[]{button1, button2});

        return menu;
    }

    /**
     * 生成菜单
     * @param token
     *                  ACCESS_TOKEN
     * @param menu
     *                  菜单实例
     * @return
     */
    public static int createMenu(String token, String menu) {
        int result = 0;
        String url = Constant.MENU_CREATE_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = httpRequest(url, Constant.POST_METHOD,menu);
        if (jsonObject != null) {
            result = jsonObject.getInt("errcode");
            System.out.println(result);
        }
        return result;
    }

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
            urlConnection.setRequestMethod(Constant.POST_METHOD);

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
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
