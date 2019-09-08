package com.wx.gzh.api;

import com.wx.gzh.service.WxUserInfoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;

/**
 * 对外的数据访问接口
 * @author Junn
 * @since 2019/6/14 0014
 */
@RestController
//@Controller
@RequestMapping("/api/conn")
public class ApiController {

    @Autowired
    private WxUserInfoIService wxUserInfoIService;

    @RequestMapping("data")
    @ResponseBody
    public String apiData() {
        return "Data Interface.";
    }

    @RequestMapping("js")
    public String apiJS() {
        System.out.println(ResourceUtils.isUrl("classpath:wx/MP_verify_oaIFVjiAklC5ysqW.txt"));
        if (ResourceUtils.isUrl("classpath:wx/MP_verify_oaIFVjiAklC5ysqW.txt")) {
            try {
                File file = ResourceUtils.getFile("classpath:wx/MP_verify_oaIFVjiAklC5ysqW.txt");
                FileWriter fw = new FileWriter(file);
                FileOutputStream fos = new FileOutputStream(String.valueOf(fw));
                System.out.println(fos);
            } catch (FileNotFoundException ignored) {

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "classpath:";
    }

    @RequestMapping("user")
    public String apiUserInfo(@RequestParam("username") String username, @RequestParam("password") String password) {
        boolean result = wxUserInfoIService.isUserInfo(username, password);
        System.out.println("result = " + result);
        if (result) {
            return "10001";
        }
        return "10002";
    }
}
