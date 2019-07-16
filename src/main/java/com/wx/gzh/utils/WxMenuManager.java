package com.wx.gzh.utils;

import com.wx.gzh.constant.Constant;
import com.wx.gzh.entity.Button;
import com.wx.gzh.entity.Menu;
import com.wx.gzh.model.WxCommonButton;
import com.wx.gzh.model.WxComplexButton;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.wx.gzh.utils.WxAccessTokenUtils.httpRequest;

/**
 * 微信菜单管理器
 * @Auther Junn
 * @Date 2019/6/24 0024下午 15:22
 */
public class WxMenuManager {
    private static Logger log = LoggerFactory.getLogger(WxMenuManager.class);
    /**
     * 创建菜单， 移动到WxMenuManager类中
     * @param menu
     *                      菜单实例
     * @param accessToken
     *                      获取Token
     * @return
     *                      0成功
     */
    public static int createMenus(Menu menu, String accessToken) {
        int result = 0;
        // 拼装创建菜单的URL
        String url = Constant.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
        // 将菜单对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(menu).toString();
        // 调用接口创建菜单
        JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return result;
    }

    /**
     * 组装菜单数据
     * @return
     */
    public static Menu getMenu() {
        WxCommonButton button11 = new WxCommonButton();
        button11.setName("公司简介1");
        button11.setType("click");
        button11.setKey("11");

        WxCommonButton button12 = new WxCommonButton();
        button12.setName("公司简介2");
        button12.setType("click");
        button12.setKey("12");

        WxCommonButton button21 = new WxCommonButton();
        button21.setName("项目案例1");
        button21.setType("click");
        button21.setKey("21");

        WxCommonButton button22 = new WxCommonButton();
        button22.setName("项目案例2");
        button22.setType("click");
        button22.setKey("22");

        WxCommonButton button31 = new WxCommonButton();
        button31.setName("后台应用1");
        button31.setType("click");
        button31.setKey("31");

        WxCommonButton button32 = new WxCommonButton();
        button32.setName("后台应用2");
        button32.setType("click");
        button32.setKey("32");

        WxComplexButton mainButton1 = new WxComplexButton();
        mainButton1.setName("公司简介");
        mainButton1.setSubButton(new WxCommonButton[]{button11, button12});

        WxComplexButton mainButton2 = new WxComplexButton();
        mainButton2.setName("项目案例");
        mainButton2.setSubButton(new WxCommonButton[]{button21, button22});

        WxComplexButton mainButton3 = new WxComplexButton();
        mainButton3.setName("后台应用");
        mainButton3.setSubButton(new WxCommonButton[]{button31, button32});

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainButton1, mainButton2, mainButton3});
        System.out.println("menu: >>>>>> " + menu.toString());
        return menu;
    }

}
