package com.wx.gzh.api;

import com.wx.gzh.utils.WxQRCodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取二维码Controller
 * @author Junn
 * @since 2019/6/26 0026上午 10:35
 */
@RestController
@RequestMapping("/wx/get")
public class WxGetTicketController {

    @GetMapping("tickets")
    public String getTicket() {
        String ticket = WxQRCodeUtil.getQrCodeTempTicket();
        return ticket;
    }

}
