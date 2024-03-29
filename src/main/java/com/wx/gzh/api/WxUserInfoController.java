package com.wx.gzh.api;

import com.wx.gzh.entity.user.WxUserInfo;
import com.wx.gzh.service.WxUserInfoIService;
import com.wx.gzh.utils.JsonResult;
import com.wx.gzh.utils.JsonToClass;
import com.wx.gzh.utils.WxQRCodeUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器类
 * @author Junn
 * @since 2019/7/17 0017下午 15:10
 */
@RestController
@RequestMapping("/wx/user")
public class WxUserInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxUserInfoController.class);

    @Autowired
    private WxUserInfoIService wxUserInfoService;

    @RequestMapping("/add")
    public JsonResult addWxUserInfo() {
        JSONObject object = WxQRCodeUtil.scanQRCode();
        WxUserInfo userInfo = new JsonToClass().jsonToWxUserInfo(object.toString());
        int result = wxUserInfoService.insertUserInfo(userInfo);
        if (result > 0) {
            return new JsonResult(true, "保存用户信息成功!");
        } else {
            LOGGER.error("保存已关注用户信息失败!");
            return new JsonResult(false, "保存用户信息失败!");
        }
    }

}
