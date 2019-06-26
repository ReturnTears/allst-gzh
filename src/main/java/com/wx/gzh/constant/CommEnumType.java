package com.wx.gzh.constant;

/**
 * Enum
 * @Auther JUNN
 * @Date 2019-06-26 下午 11:38
 */
public class CommEnumType {
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
}
