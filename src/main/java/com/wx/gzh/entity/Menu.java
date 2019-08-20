package com.wx.gzh.entity;

import com.wx.gzh.entity.button.Button;

import java.util.Arrays;

/**
 * 微信公众号菜单项:
 *      自定义菜单能够帮助公众号丰富界面，让用户更好更快地理解公众号的功能
 * @Auther Junn
 * @Date 2019/6/24 0024下午 14:41
 */
public class Menu {
    private Button[] button;

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "button=" + Arrays.toString(button) +
                '}';
    }
}
