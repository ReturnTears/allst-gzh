package com.wx.gzh.model;

import com.wx.gzh.entity.button.Button;

/**
 * 子菜单项
 * @Auther Junn
 * @Date 2019/6/24 0024下午 14:36
 */
public class WxCommonButton extends Button {
    private String type;
    private String name;
    private String key;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
