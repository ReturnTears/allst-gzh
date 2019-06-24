package com.wx.gzh.tools;

import com.wx.gzh.model.Button;

/**
 * 混合菜单项
 * @Auther Junn
 * @Date 2019/6/24 0024下午 14:40
 */
public class WxComplexButton extends Button {

    private Button[] sub_button;

    public Button[] getSubButton() {
        return sub_button;
    }

    public void setSubButton(Button[] subButton) {
        this.sub_button = subButton;
    }
}
