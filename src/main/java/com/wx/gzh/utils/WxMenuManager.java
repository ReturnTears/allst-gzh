package com.wx.gzh.utils;

import com.wx.gzh.model.Button;
import com.wx.gzh.model.WxMenu;
import com.wx.gzh.tools.WxCommonButton;
import com.wx.gzh.tools.WxComplexButton;

/**
 * 微信菜单管理器
 * @Auther Junn
 * @Date 2019/6/24 0024下午 15:22
 */
public class WxMenuManager {

    /**
     * 组装菜单数据
     * @return
     */
    public static WxMenu getMenu() {
        WxCommonButton button11 = new WxCommonButton();
        button11.setName("公司简介1");
        button11.setType("click");
        button11.setKey("11");

        WxCommonButton button12 = new WxCommonButton();
        button12.setName("公司简介2");
        button12.setType("click");
        button12.setKey("12");

        WxCommonButton button13 = new WxCommonButton();
        button13.setName("公司简介3");
        button13.setType("click");
        button13.setKey("13");

        WxCommonButton button21 = new WxCommonButton();
        button21.setName("项目案例1");
        button21.setType("click");
        button21.setKey("21");

        WxCommonButton button22 = new WxCommonButton();
        button22.setName("项目案例2");
        button22.setType("click");
        button22.setKey("22");

        WxCommonButton button23 = new WxCommonButton();
        button23.setName("项目案例3");
        button23.setType("click");
        button23.setKey("23");

        WxCommonButton button31 = new WxCommonButton();
        button31.setName("后台应用1");
        button31.setType("click");
        button31.setKey("31");

        WxCommonButton button32 = new WxCommonButton();
        button32.setName("后台应用2");
        button32.setType("click");
        button32.setKey("32");

        WxCommonButton button33 = new WxCommonButton();
        button33.setName("后台应用3");
        button33.setType("click");
        button33.setKey("33");

        WxComplexButton mainButton1 = new WxComplexButton();
        mainButton1.setName("公司简介");
        mainButton1.setSubButton(new WxCommonButton[]{button11, button12, button13});

        WxComplexButton mainButton2 = new WxComplexButton();
        mainButton2.setName("项目案例");
        mainButton2.setSubButton(new WxCommonButton[]{button21, button22, button23});

        WxComplexButton mainButton3 = new WxComplexButton();
        mainButton3.setName("后台应用");
        mainButton3.setSubButton(new WxCommonButton[]{button31, button32, button33});

        WxMenu menu = new WxMenu();
        menu.setButton(new Button[]{mainButton1, mainButton2, mainButton3});
        return menu;
    }

}
