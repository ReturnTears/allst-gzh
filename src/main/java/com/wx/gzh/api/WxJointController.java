package com.wx.gzh.api;

import com.wx.gzh.service.WxAcceptMsgIService;
import com.wx.gzh.service.WxHandlerMsgIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.wx.gzh.utils.WxJointUtil.validate;

/**
 * 微信公众号的接入入口
 * @author Junn
 * @since 2019/6/19 0019
 */
@RestController
@RequestMapping("/join")
public class WxJointController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxJointController.class);

    @Autowired
    private WxAcceptMsgIService wxAcceptMsgIService;

    @Autowired
    private WxHandlerMsgIService wxHandlerMsgService;

    /**
     * 微信公众号接入方法
     * @param request
     *                  HttpServletRequest
     * @param response
     *                  HttpServletResponse
     * @throws IOException
     *                  IO异常
     */
    @RequestMapping(value="wx",method=RequestMethod.GET)
    @ResponseBody
    public void jointWx(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean validate = validate(request);
        if (validate) {
            LOGGER.info("接入微信公众平台成功.");
            response.getWriter().write(request.getParameter("echostr"));
            response.getWriter().close();
        }
    }

    /**
     * 接受消息以及回复消息
     * @param request
     *                  HttpServletRequest
     * @param response
     *                  HttpServletResponse
     * @return
     *                  回复的消息内容
     */
    @RequestMapping(value = "wx", method = RequestMethod.POST)
    @ResponseBody
    public String getWxAcceptMsg(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> res = wxAcceptMsgIService.joinWxMsg(request, response);
        // 消息的统一处理, 需要将回复的消息封装为上述格式的xml内容
        return wxHandlerMsgService.replayMsgs(res);
    }
}
