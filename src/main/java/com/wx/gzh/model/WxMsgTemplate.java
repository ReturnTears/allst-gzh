package com.wx.gzh.model;

/**
 * Wx模板消息类
 * @author JUNN
 * @since 2019/8/22 0022 下午 17:48
 */
public class WxMsgTemplate {
    /**
     * 接收者openid
     */
    private String touser;
    /**
     * 模板ID
     */
    private String template_id;
    /**
     * 非必选
     * 模板跳转链接（海外帐号没有跳转能力）
     */
    private String url;
    /**
     * 非必选
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     */
    private String miniprogram;
    /**
     * 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
     */
    private String appid;
    /**
     * 非必选
     * 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），要求该小程序已发布，暂不支持小游戏
     */
    private String pagepath;
    /**
     * 非必选
     * 模板内容字体颜色，不填默认为黑色
     */
    private String color;
    /**
     * 模板数据
     */
    private String data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(String miniprogram) {
        this.miniprogram = miniprogram;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * 按微信接口要求格式化模板
     * @return
     *              模板格式字JSON符串
     */
    public String toJSON() {

        return "";
    }
}