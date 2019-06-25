package com.wx.gzh.utils;

import com.wx.gzh.constant.Constant;

/**
 * 微信二维码工具类
 * @Auther Junn
 * @Date 2019/6/25 0025下午 17:28
 */
public class WxQRCodeUtil {
    /**
     * 获取带参数的二维码Ticket
     * @return
     */
    public static String getQrCodeTicket() {
        // 获取ACCESSTOKEN
        String accessToken = WxAccessTokenUtils.getAccessToken();
        String url = Constant.WX_QRCODE.replace("TOKEN", accessToken);
        // 临时二维码POST数据
        String jsonTempData = "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 123}}}";
        // 永久二维码POST数据
        String jsonPermData = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 123}}}";
        return "";
    }
}
