package com.wx.gzh;

import com.wx.gzh.model.AccessToken;
import com.wx.gzh.utils.WeiXinUtil;
import com.wx.gzh.utils.WxMenuManager;
import com.wx.gzh.utils.WxAccessTokenUtils;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static com.wx.gzh.constant.Constant.APPID;
import static com.wx.gzh.constant.Constant.APPSECRET;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllstGzhApplicationTests {

    @Test
    public void contextLoads() {
        // 1
        String[] strs = new String[]{"TOKEN", "1230125487", "hhh"};
        Arrays.sort(strs);
        // 2 将拍下后的结果拼成一个字符串
        String str = strs[0].concat(strs[1]).concat(strs[2]);
        System.out.println(str);
    }

    @Test
    public void testMenu() {
        AccessToken token = WxAccessTokenUtils.getAccessToken(APPID, APPSECRET);
        if (token != null) {
            int result = WxMenuManager.createMenus(WxMenuManager.getMenu(), token.getAccess_token());
            // 判断菜单创建结果
            if (0 == result)
                System.out.println("菜单创建成功！");
            else
                System.out.println("菜单创建失败！" + result);
        }
    }

    @Test
    public void testCreateMenu() {
        String token = WxAccessTokenUtils.getAccessToken();
        String menu = JSONObject.fromObject(WeiXinUtil.initMenu()).toString();
        int result = WeiXinUtil.createMenu(token, menu);
        if (result == 0) {
            System.out.println("菜单创建成功");
        } else {
            System.out.println("菜单创建失败");
        }
    }

    @Test
    public void testAccessToken() {
        WxAccessTokenUtils.getToken();
    }

}
