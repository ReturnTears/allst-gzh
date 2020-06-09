package com.wx.gzh.entity.button;

import lombok.Data;

/**
 * 一级菜单：
 *      一级菜单数组，个数应为1~3个
 * @author Junn
 * @since 2019/6/24 0024下午 14:34
 */
@Data
public class Button {
    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    private String name;
    /**
     * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
     */
    private String type;
    /**
     * 二级菜单数组，个数应为1~5个
     */
    private Button[] sub_button;
}
