package com.wx.gzh.model;

/**
 * 模板数据的内容
 * @author JUNN
 * @since 2019/8/23 0023 下午 14:20
 */
public class WxTemplateData {
    private String name;
    private String value;
    private String color;

    public WxTemplateData() {
    }

    public WxTemplateData(String name, String value, String color) {
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
