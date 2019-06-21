package com.wx.gzh.tools;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wx.gzh.annotation.XStreamCDATA;
import com.wx.gzh.model.Articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 微信News类型消息
 * @Auther Junn
 * @Date 2019/6/19 0019
 */
@XStreamAlias("xml")
public class WxNewsMessage extends WxBaseMessgae {

    @XStreamAlias("ArticleCount")
    private String ArticleCount;

    @XStreamAlias("Articles")
    @XStreamCDATA
    private List<Articles> articles = new ArrayList<>();

    public String getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(String articleCount) {
        this.ArticleCount = articleCount;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public WxNewsMessage() {}

    public WxNewsMessage(String articleCount, List<Articles> articles) {
        this.ArticleCount = articleCount;
        this.articles = articles;
    }

    public WxNewsMessage(Map<String, String> map, String articleCount, List<Articles> articles) {
        super(map);
        setMsgType("news");
        this.ArticleCount = articleCount;
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "WxNewsMessage{" +
                "ArticleCount='" + ArticleCount + '\'' +
                ", articles=" + articles +
                '}';
    }
}
