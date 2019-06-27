package com.wx.gzh.constant;

/**
 * Enum类型常量
 * @Auther JUNN
 * @Date 2019-06-26 下午 11:38
 */
public class CommEnum {
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
        UTF8编码("UTF-8"), GBK编码("GBK");

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
