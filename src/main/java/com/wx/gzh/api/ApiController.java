package com.wx.gzh.api;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
