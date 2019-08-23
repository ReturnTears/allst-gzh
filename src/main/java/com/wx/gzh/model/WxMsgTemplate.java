package com.wx.gzh.model;

import java.util.List;

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
    /**
     * 模板数据
     */
    private List<TemplateData> templateDataList;

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

    public List<TemplateData> getTemplateDataList() {
        return templateDataList;
    }

    public void setTemplateDataList(List<TemplateData> templateDataList) {
        this.templateDataList = templateDataList;
    }

    /**
     * 模板数据类
     */
    class TemplateData {
        private String name;
        private String value;
        private String color;

        public TemplateData(String name, String value, String color) {
            this.name = name;
            this.value = value;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    /**
     * 按微信接口要求格式化模板
     * @return
     *              模板格式字JSON符串
     */
    public String toJSON() {
        /**
         * 数据格式如下:
         * {
         *    "touser":"OPENID",
         *    "template_id":"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
         *    "url":"http://weixin.qq.com/download",
         *    "miniprogram":{
         *      "appid":"xiaochengxuappid12345",
         *      "pagepath":"index?foo=bar"
         *    },
         *    "data":{
         *            "first": {
         *                "value":"恭喜你购买成功！",
         *                "color":"#173177"
         *            },
         *            "keyword1":{
         *                "value":"巧克力",
         *                "color":"#173177"
         *            },
         *            "keyword2": {
         *                "value":"39.8元",
         *                "color":"#173177"
         *            },
         *            "keyword3": {
         *                "value":"2014年9月22日",
         *                "color":"#173177"
         *            },
         *            "remark":{
         *                "value":"欢迎再次购买！",
         *                "color":"#173177"
         *            }
         *    }
         * }
         */
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        buffer.append(String.format("\"touser\":\"%s\"", this.touser)).append(",");
        buffer.append(String.format("\"template_id:\":\"%s\"", this.template_id)).append(",");
        buffer.append(String.format("\"url:\":\"%s\"", this.url)).append(",");
        buffer.append(String.format("\"color:\":\"%s\"", this.color)).append(",");
        buffer.append(String.format("\"data\":{"));
        TemplateData param = null;
        for (int i = 0; i < this.templateDataList.size(); i++) {
            param = templateDataList.get(i);
            // 判断是否需要追加逗号
            if (i < this.templateDataList.size() - 1) {
                buffer.append(String.format("\"%s\":{\"value\":\"%s\",\"color\":\"%s\"},", param.getName(), param.getValue(), param.getColor()));
            } else {
                buffer.append(String.format("\"%s\":{\"value\":\"%s\",\"color\":\"%s\"}", param.getName(), param.getValue(), param.getColor()));
            }
        }
        buffer.append("}").append("}");
        return buffer.toString();
    }
}
