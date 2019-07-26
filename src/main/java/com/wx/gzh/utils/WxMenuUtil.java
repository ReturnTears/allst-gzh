package com.wx.gzh.utils;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.constant.Constant;
import com.wx.gzh.entity.Button;
import com.wx.gzh.entity.ClickButton;
import com.wx.gzh.entity.Menu;
import com.wx.gzh.entity.ViewButton;
import net.sf.json.JSONObject;
/**
 * WeiXinUtil工具类
 * @Auther Junn
 * @Date 2019/6/25 0025下午 14:51
 */
public class WxMenuUtil {
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
        button13.setName("招聘信息");
        button13.setType("click");
        button13.setKey("13");

        ClickButton button14 = new ClickButton();
        button13.setName("其他");
        button13.setType("click");
        button13.setKey("14");

        ViewButton button21 = new ViewButton();
        button21.setName("进入项目");
        button21.setType("view");
        button21.setUrl("http://huwx.free.idcfengye.com/web/conn/inde");

        ViewButton button22 = new ViewButton();
        button22.setName("图标预览");
        button22.setType("view");
        button22.setUrl("http://huwx.free.idcfengye.com/web/conn/inde");

        ViewButton button23 = new ViewButton();
        button23.setName("APP下载");
        button23.setType("view");
        button23.setUrl("http://huwx.free.idcfengye.com/web/front/profile");

        ViewButton button24 = new ViewButton();
        button24.setName("测试用");
        button24.setType("view");
        button24.setUrl("http://huwx.free.idcfengye.com/web/conn/inde");

        Button button1 = new Button();
        button1.setName("关于公司");
        button1.setSub_button(new Button[]{button11, button12, button13});

        Button button2 = new Button();
        button2.setName("关于项目");
        button2.setSub_button(new Button[]{button21, button22, button23, button24});

        menu.setButton(new Button[]{button1, button2});

        return menu;
    }

    /**
     * 创建菜单
     * @param token
     *                  ACCESS_TOKEN
     * @param menu
     *                  菜单实例
     * @return
     */
    public static int createMenu(String token, String menu) {
        int result = 0;
        String url = Constant.MENU_CREATE_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = WxHttpUtil.httpRequest(url, CommEnum.RequestMode.POST请求.getValue(), menu);
        if (jsonObject != null) {
            result = jsonObject.getInt("errcode");
            System.out.println(result);
        }
        return result;
    }

    /**
     * 删除菜单
     * @param token
     *                  ACCESS_TOKEN
     */
    public static void deleteMenu(String token) {
        String url = Constant.MENU_DELETE_URL.replace("ACCESS_TOKEN", token);
        int result;
        JSONObject jsonObject = WxHttpUtil.httpRequest(url, CommEnum.RequestMode.GET请求.getValue(), "");
        if (jsonObject != null) {
            result = jsonObject.getInt("errcode");
            System.out.println(result);
        }
    }

}
