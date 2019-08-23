package com.wx.gzh;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.entity.token.AccessToken;
import com.wx.gzh.utils.*;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static com.wx.gzh.constant.Constant.*;
import static com.wx.gzh.utils.WxMenuUtil.deleteMenu;
import static com.wx.gzh.utils.WxQRCodeUtil.scanQRCode;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllstGzhApplicationTests {

    @Test
    public void contextLoads() {
        // 1
        String[] strs = new String[]{"TOKEN--", "1230125487", "--hhh"};
        Arrays.sort(strs);
        // 2 将拍下后的结果拼成一个字符串
        String str = strs[0].concat(strs[1]).concat(strs[2]);
        System.out.println(str);
    }

    @Test
    public void testMenu() {
        AccessToken token = WxAccessTokenUtils.getAccessToken(APPID, APPSECRET);
        if (token != null) {
            int result = WxMenuUtil.createMenus(WxMenuUtil.getMenu(), token.getAccess_token());
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
        String menu = JSONObject.fromObject(WxMenuUtil.initMenu()).toString();
        System.out.println("menu : " + menu);
        int result = WxMenuUtil.createMenu(token, menu);
        if (result == 0) {
            System.out.println("菜单创建成功");
        } else {
            System.out.println("菜单创建失败");
        }
    }

    @Test
    public void testDeleteMenu() {
        String token = WxAccessTokenUtils.getAccessToken();
        deleteMenu(token);
    }

    @Test
    public void testAccessToken() {
        WxAccessTokenUtils.getToken();
    }

    @Test
    public void testQRCode() {
        // 临时带参数二维码
        // String ticketTemp = WxQRCodeUtil.getQrCodeTempTicket();
        // 永久带参数二维码
        String ticketPerm = WxQRCodeUtil.getQrCodePermTicket();
        System.out.println(ticketPerm);
    }

    @Test
    public void testScanQrCode() {
        scanQRCode();
    }

    @Test
    public void testTempDir() {
        System.out.println(TMPDIR);
        System.out.println(CommEnum.MatterType.图片.getValue());
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 素材类型
     */
    @Test
    public void testMatter() {
        String file = "C:\\Users\\Administrator\\Pictures\\111.PNG";
        JSONObject result = WxMatterUtil.uploadTempMaterial();
        System.out.println("upload matter : " + result);
    }
}
