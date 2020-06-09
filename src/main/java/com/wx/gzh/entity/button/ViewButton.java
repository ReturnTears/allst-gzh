package com.wx.gzh.entity.button;

import lombok.Data;

/**
 * view类型按钮
 * @author  Junn
 * @since  2019/6/25 0025下午 14:49
 */
@Data
public class ViewButton extends Button {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
