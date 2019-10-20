package com.wx.gzh.utils;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.constant.Constant;
import com.wx.gzh.entity.button.Button;
import com.wx.gzh.entity.Menu;
import com.wx.gzh.entity.button.ClickButton;
import com.wx.gzh.entity.button.ViewButton;
import com.wx.gzh.model.WxCommonButton;
import com.wx.gzh.model.WxComplexButton;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WeiXinUtil工具类
 * @author JUNN
 * @since 2019/6/25 0025下午 14:51
 */
public class WxMenuUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxMenuUtil.class);
    /**
     * 初始化菜单
     * @return
     *          Menu对象
     */
    public static Menu initMenu() {
        Menu menu = new Menu();

        ViewButton button11 = new ViewButton();
        button11.setName("公司简介");
        button11.setType("view");
        button11.setUrl("http://home.58iim.com:10086/index.php/index.html");

        ViewButton button12 = new ViewButton();
        button12.setName("项目案例");
        button12.setType("view");
        button12.setUrl("http://psk.free.idcfengye.com/web/front/proj");

        ViewButton button13 = new ViewButton();
        button13.setName("人才招聘");
        button13.setType("view");
        button13.setUrl("http://psk.free.idcfengye.com/web/front/jobs");

        ClickButton button14 = new ClickButton();
        button13.setName("其他");
        button13.setType("click");
        button13.setUrl("14");

        ViewButton button21 = new ViewButton();
        button21.setName("成宜高速测试");
        button21.setType("view");
        button21.setUrl("http://47.101.154.109:10100/admin/web/login");
        /*button21.setUrl("http://47.101.154.109:10100/admin/web/login");*/

        /*ViewButton button22 = new ViewButton();
        button22.setName("云凤高速");
        button22.setType("view");
        button22.setUrl("http://huwx.free.idcfengye.com/web/front/proj");*/

        /*ViewButton button23 = new ViewButton();
        button23.setName("项目C");
        button23.setType("view");
        button23.setUrl("http://47.101.154.109:10100/admin/web/login");*/

        ViewButton button31 = new ViewButton();
        button31.setName("测试使用");
        button31.setType("view");
        button31.setUrl("http://psk.free.idcfengye.com/wx/oauth/code");

        Button button1 = new Button();
        button1.setName("关于公司");
        button1.setSub_button(new Button[]{button11, button12, button13});

        /*Button button3 = new Button();
        button3.setName("网页授权");
        button3.setSub_button(new Button[]{button31});*/

        Button button2 = new Button();
        button2.setName("关于项目");
        button2.setSub_button(new Button[]{button21});

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
     *                  成功返回0， 失败返回！0
     */
    public static int createMenu(String token, String menu) {
        int result = 0;
        String url = Constant.MENU_CREATE_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = WxHttpUtil.httpRequest(url, CommEnum.RequestMode.POST请求.getValue(), menu);
        if (CoreToolsUtil.isNotEmpty(jsonObject)) {
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
        JSONObject jsonObject = WxHttpUtil.httpRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                LOGGER.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return result;
    }

    /**
     * 组装自己公众号的菜单数据
     * @return
     */
    public static Menu initSelfMenu() {
        WxCommonButton button11 = new WxCommonButton();
        button11.setName("美文分享");
        button11.setType("click");
        button11.setKey("11");

        WxCommonButton button12 = new WxCommonButton();
        button12.setName("图文赏析");
        button12.setType("click");
        button12.setKey("12");

        WxCommonButton button21 = new WxCommonButton();
        button21.setName("图文分享");
        button21.setType("click");
        button21.setKey("21");

        WxCommonButton button22 = new WxCommonButton();
        button22.setName("PS技术分享");
        button22.setType("click");
        button22.setKey("22");

        WxCommonButton button31 = new WxCommonButton();
        button31.setName("编程语言");
        button31.setType("click");
        button31.setKey("31");

        WxCommonButton button32 = new WxCommonButton();
        button32.setName("Github地址");
        button32.setType("click");
        button32.setKey("32");

        WxComplexButton mainButton1 = new WxComplexButton();
        mainButton1.setName("软文介绍");
        mainButton1.setSubButton(new WxCommonButton[]{button11, button12});

        WxComplexButton mainButton2 = new WxComplexButton();
        mainButton2.setName("图文介绍");
        mainButton2.setSubButton(new WxCommonButton[]{button21, button22});

        WxComplexButton mainButton3 = new WxComplexButton();
        mainButton3.setName("技术介绍");
        mainButton3.setSubButton(new WxCommonButton[]{button31, button32});

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainButton1, mainButton2, mainButton3});
        System.out.println("menu: >>>>>> " + menu.toString());
        return menu;
    }

}
