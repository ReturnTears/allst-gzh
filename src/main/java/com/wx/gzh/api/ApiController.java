package com.wx.gzh.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对外的数据访问接口
 * @author Junn
 * @since 2019/6/14 0014
 */
@RestController
@RequestMapping("/api/conn")
public class ApiController {
    @RequestMapping("data")
    public String apiData() {
        return "Data Interface.";
    }
}
