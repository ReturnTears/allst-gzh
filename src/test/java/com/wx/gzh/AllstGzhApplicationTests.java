package com.wx.gzh;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.entity.token.AccessToken;
import com.wx.gzh.utils.*;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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
            int result = WxMenuUtil.createMenus(WxMenuUtil.initSelfMenu(), token.getAccess_token());
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
    public void testCreateSelfMenu() {
        String token = WxAccessTokenUtils.getAccessToken();
        String menu = JSONObject.fromObject(WxMenuUtil.initSelfMenu()).toString();
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

    /**
     * 测试Map对象数据
     * {
     *     "touser":"o_Ag01ZEmXLI2gCkgSaCmn6FYbmI",
     *     "template_id":"FEbG1tlcb0vQAEE3l4OfXuTyNXqv4fZay6nH7QnHGk4",
     * 	   "url":"https://www.baidu.com/",
     *     "topcolor":"red",
     *     "data":{
     * 	    "first": {
     * 	        "value":"黄先生",
     * 	        "color":"#173177"
     *                },
     * 	    "time":{
     * 	        "value":"06月07日 19时24分",
     * 	        "color":"#173177"
     *        },
     * 	    "content": {
     * 	        "value":"0426",
     * 	        "color":"#173177"
     *        },
     * 	    "remark":{
     * 	        "value":"点击查看详情...",
     * 	        "color":"#173177"
     *        }
     *     }
     * }
     */
    @Test
    public void testMapObj() {
        Map<String, Object> map = new HashMap<>();
        map.put("touser", "o_Ag01ZEmXLI2gCkgSaCmn6FYbmI");
        map.put("template_id", "FEbG1tlcb0vQAEE3l4OfXuTyNXqv4fZay6nH7QnHGk4");
        map.put("url", "https://www.baidu.com/");
        map.put("topcolor", "#FF0000");

        Map<String, Object> childMap = new HashMap<>();
        String[] params = {"first", "time", "content", "remark"};

        Map<String, Object> firstMap = new HashMap<>();
        firstMap.put("name", "first");
        firstMap.put("value", "JUNN");
        firstMap.put("color", "#173177");
        childMap.put(params[0], firstMap);

        Map<String, Object> timeMap = new HashMap<>();
        timeMap.put("name", "time");
        timeMap.put("value", "2019-08-30 12:12:12");
        timeMap.put("color", "#171717");
        childMap.put(params[1], timeMap);

        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("name", "content");
        contentMap.put("value", "这是一条消息通知测试数据...");
        contentMap.put("color", "#214577");
        childMap.put(params[2], contentMap);

        Map<String, Object> remarkMap = new HashMap<>();
        remarkMap.put("name", "remark");
        remarkMap.put("value", "JUNN");
        remarkMap.put("color", "#173177");
        childMap.put(params[3], remarkMap);

        List<Object> list = new ArrayList<>();
        list.add(0, firstMap);
        list.add(1, timeMap);
        list.add(2, contentMap);
        list.add(3, remarkMap);

        map.put("data", list);

        System.out.println("Map : " + map);

        String result = WxMsgUtil.tempMsg2JSON(map);
        System.out.println("result : " + result);

    }

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    /**
     * 测试Redis
     */
    @Test
    public void test() {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("redisKey","cluster test");
        System.out.println(opsForValue.get("redisKey"));
    }
}
