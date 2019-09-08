package com.wx.gzh.constant;

/**
 * Enum类型常量
 * @author JUNN
 * @since 2019-06-26 下午 11:38
 */
public class CommEnum {
    /**
     * 结果编码
     */
    public enum ResultCode {
        SUCCESS("10001"), FAILURE("10002"), ERROR("10003");

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        ResultCode(String value) {
            this.value = value;
        }
    }

    /**
     * 默认常用关键词, 补充的关键词放到Redis中
     */
    public enum KeyWord {
        登录("LOGIN"), 扫描("SCAN"), 二维码("QRCODE"), 普斯克("PSK"), 时间("TIME"), 项目("PROJECT");

        private String value;

        KeyWord(String value) {
            this.value = value;
        }
    }

    /**
     * 默认消息类型
     */
    public enum MsgType {
        文本消息("Text", 101), 图片消息("Image", 102), 语音消息("Voice", 103), 视频消息("Video", 104), 小视频消息("ShortVideo", 105),

        地理位置消息("Location", 106), 链接消息("Link", 107), 图文消息("News", 108);

        private String value;

        private Integer nums;

        public String getValue() {
            return value;
        }

        public Integer getNums() {
            return nums;
        }

        MsgType(String value) {
            this.value = value;
        }

        MsgType(Integer nums) {
            this.nums = nums;
        }

        MsgType(String value, Integer nums) {
            this.value = value;
            this.nums = nums;
        }
    }

    /**
     * 默认事件类型
     */
    public enum EventType {
        关注事件("subscribe", 201), 取消关注事件("unsubscribe", 202), 扫描事件("SCAN", 203), 上报地理位置事件("LOCATION", 204), 自定义菜单事件("CLICK", 205);

        private String value;

        private Integer nums;

        public String getValue() {
            return value;
        }

        public Integer getNums() {
            return nums;
        }

        EventType(String value, Integer nums) {
            this.value = value;
            this.nums = nums;
        }

        EventType(Integer nums) {
            this.nums = nums;
        }

        EventType(String value) {
            this.value = value;
        }
    }

    /**
     * 默认消息来源:
     *          0 - 消息来自用户(服务器接收用户的消息)，
     *          1 - 消息来自服务器(服务器向用户推送消息)，
     *          2 - 消息来自微信服务(服务接收微信服务的消息)
     */
    public enum MsgSource {
        用户(0), 服务器(1), 微信服务(2);

        private Integer value;

        public Integer getValue() {
            return value;
        }

        MsgSource(Integer value) {
            this.value = value;
        }
    }

    /**
     * 素材类型:
     */
    public enum MatterType {
        图片("image"), 语音("voice"), 视频("video"), 缩略图("thumb");

        private String value;

        public String getValue() {
            return value;
        }

        MatterType(String value) {
            this.value = value;
        }
    }

    /**
     * 请求方式
     */
    public enum RequestMode {
        GET请求("GET"), POST请求("POST"), PUT请求("PUT"), DELETE请求("DELETE");

        private String value;

        public String getValue() {
            return value;
        }

        RequestMode(String value) {
            this.value = value;
        }
    }

    /**
     * 编码方式
     */
    public enum EncodingMode {
        UTF8("UTF-8"), GBK("GBK");

        private String value;

        public String getValue() {
            return value;
        }

        EncodingMode(String value) {
            this.value = value;
        }
    }

    /**
     * 语言类型
     */
    public enum LanguageType {
        简体("zh_CN"), 繁体("zh_TW"), 英语("en");
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        LanguageType(String value) {
            this.value = value;
        }
    }
}
