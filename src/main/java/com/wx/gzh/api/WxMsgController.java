package com.wx.gzh.api;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.constant.Constant;
import com.wx.gzh.service.WxMsgIService;
import com.wx.gzh.utils.CoreToolsUtil;
import com.wx.gzh.utils.WxAccessTokenUtils;
import com.wx.gzh.utils.WxHttpUtil;
import com.wx.gzh.utils.WxMsgUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 接收消息，发送消息Controller
 * @author Junn
 * @since 2019/6/19 0019
 */
@Controller
@RequestMapping("/wx/msg")
public class WxMsgController {

    @Autowired
    private WxMsgIService wxMsgIService;

    @RequestMapping(value = "accept", method = RequestMethod.GET)
    public String getWxAcceptMsg(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("accept msg");
        Map<String, String> res = wxMsgIService.joinWxMsg(request, response);
        System.out.println("res" + res);
        return null;
    }

    /**
     * 发送模板消息
     * @return
     *          成功返回Success， 失败返回Failure
     */
    @ResponseBody
    @RequestMapping(value = "temp", method = {RequestMethod.GET, RequestMethod.POST})
    public String sendWxTemplateMsg(@RequestParam Map<String, Object> params) {
        System.out.println("数据包的长度 : " + params.size());
        if (CoreToolsUtil.isNotEmpty(params)) {
            boolean flag = wxMsgIService.sendTempMessage(params);
            if (flag) {
                return "Success";
            }
        }
        return "Failure";
    }

    /**
     * 发送模板消息
     * @param jsonStr
     *                  发送的消息数据JSON串
     *                  {"touser":"o_Ag01ZEmXLI2gCkgSaCmn6FYbmI","template_id":"FEbG1tlcb0vQAEE3l4OfXuTyNXqv4fZay6nH7QnHGk4",
     *                   "url":"https://www.baidu.com/","topcolor":"#FF0000","data":
     *                          {"first": {"value":"黄先生","color":"#173177"},"time":{"value":"06月07日 19时24分","color":"#173177"},
     *                          "content": {"value":"0426","color":"#173177"},"remark":{"value":"点击查看详情...","color":"#173177"}
     *                          }
     *                  }
     * @return
     *                  成功返回Success,失败返回Failure
     */
    @ResponseBody
    @RequestMapping(value = "push", method = {RequestMethod.GET, RequestMethod.POST})
    public String sendPushMsg(@RequestBody String jsonStr) {
        if (CoreToolsUtil.isNotEmpty(jsonStr)) {
            String token = WxAccessTokenUtils.getAccessToken();
            String url = Constant.WX_TEMPLATE_MSG_SEND.replace("ACCESS_TOKEN", token);
            JSONObject jsonObject = WxHttpUtil.httpRequest(url, CommEnum.RequestMode.POST请求.getValue(), jsonStr);
            if (jsonObject != null) {
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                if (errorCode == 0) {
                    System.out.println("消息模板发生成功...");
                } else {
                    System.out.println("消息模板发送失败....errorMsg : " + errorMsg);
                }
            }
            return "Success";
        }
        return "Failure";

    }
}
