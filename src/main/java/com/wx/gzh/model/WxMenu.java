package com.wx.gzh.model;

import java.util.Arrays;

/**
 * 微信公众号菜单项
 * @Auther Junn
 * @Date 2019/6/24 0024下午 14:41
 */
public class WxMenu {
    private Button[] button;

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "WxMenu{" +
                "button=" + Arrays.toString(button) +
                '}';
    }
}
