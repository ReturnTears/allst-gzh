package com.wx.gzh.utils;

import com.wx.gzh.model.Articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 微信News类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
public class WxNewsMessage extends WxBaseMessgae {

    private String articleCount;
    private List<Articles> articles = new ArrayList<>();

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public WxNewsMessage(String articleCount, List<Articles> articles) {
        this.articleCount = articleCount;
        this.articles = articles;
    }

    public WxNewsMessage(Map<String, String> map, String articleCount, List<Articles> articles) {
        super(map);
        setMsgType("news");
        this.articleCount = articleCount;
        this.articles = articles;
    }
}
