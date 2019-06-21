package com.wx.gzh.utils;

import com.thoughtworks.xstream.XStream;
import com.wx.gzh.model.*;
import com.wx.gzh.tools.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 将Message转换为XML格式工具类
 * @Auther Junn
 * @Date 2019/6/20 0020上午 9:29
 */
public class Message2Xml {

    private static final XStream xStream = XStreamFactory.getXStream();

    /**
     * 将发送消息封装为对应的xml格式
     * @return
     */
    private static String convertToXml(Object object) {
        xStream.processAnnotations(object.getClass());
        return xStream.toXML(object);
    }

    /**
     * 回复文本消息
     * 封装发送text类型消息对象,封装时，需要将调换发送者和接收者的关系
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[text]]></MsgType>
     *   <Content><![CDATA[你好]]></Content>
     * </xml>
     * @return
     */
    public static String initTextMessage(Map<String, String> map) {
        WxTextMessage text = new WxTextMessage();
        text.setToUserName(map.get("FromUserName"));
        text.setFromUserName(map.get("ToUserName"));
        text.setCreateTime(map.get("CreateTime"));
        text.setMsgType(map.get("MsgType"));
        text.setContent(map.get("Content"));
        return convertToXml(text);
    }

    /**
     * 回复图片消息
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[image]]></MsgType>
     *   <Image>
     *     <MediaId><![CDATA[media_id]]></MediaId>
     *   </Image>
     * </xml>
     * @param map
     * @return
     */
    public static String initImageMessage(Map<String, String> map) {
        Image pic = new Image();
        pic.setMediaId(map.get("MediaId"));
        WxImageMessage image = new WxImageMessage();
        image.setImage(pic);
        image.setToUserName(map.get("FromUserName"));
        image.setFromUserName(map.get("ToUserName"));
        image.setCreateTime(map.get("CreateTime"));
        image.setMsgType(map.get("MsgType"));
        return convertToXml(image);
    }

    /**
     * 回复语音消息
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[voice]]></MsgType>
     *   <Voice>
     *     <MediaId><![CDATA[media_id]]></MediaId>
     *   </Voice>
     * </xml>
     * @param map
     * @return
     */
    public static String initVoiceMessage(Map<String, String> map) {
        Voice vo = new Voice();
        vo.setMediaId(map.get("MediaId"));
        WxVoiceMessage voice = new WxVoiceMessage();
        voice.setToUserName(map.get("FromUserName"));
        voice.setFromUserName(map.get("ToUserName"));
        voice.setCreateTime(map.get("CreateTime"));
        voice.setMsgType(map.get("MsgType"));
        voice.setVoice(vo);
        return convertToXml(voice);
    }

    /**
     * TODO 待测试
     * 回复视频消息
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[video]]></MsgType>
     *   <Video>
     *     <MediaId><![CDATA[media_id]]></MediaId>
     *     <Title><![CDATA[title]]></Title>
     *     <Description><![CDATA[description]]></Description>
     *   </Video>
     * </xml>
     * @param map
     * @return
     */
    public static String initVideoMessage(Map<String, String> map) {
        Video vi = new Video();
        vi.setTitle("<![CDATA[8e66de9a9e5432f75e39ad66b32d7e07]]>");
        vi.setDescription("<![CDATA[视频描述]]>");
        vi.setMediaId(map.get("MediaId"));
        // vi.setThumbMediaId(map.get("ThumbMediaId"));
        WxVideoMessage video = new WxVideoMessage();
        video.setToUserName(map.get("FromUserName"));
        video.setFromUserName(map.get("ToUserName"));
        video.setCreateTime(map.get("CreateTime"));
        video.setMsgType(map.get("MsgType"));
        video.setVideo(vi);
        return convertToXml(video);
    }

    /**
     * TODO 待测试
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[music]]></MsgType>
     *   <Music>
     *     <Title><![CDATA[TITLE]]></Title>
     *     <Description><![CDATA[DESCRIPTION]]></Description>
     *     <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
     *     <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
     *     <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
     *   </Music>
     * </xml>
     * @param map
     * @return
     */
    public static String initMusicMessage(Map<String, String> map){
        Music mu = new Music();
        mu.setTitle("<![CDATA[音乐标题]]>");
        mu.setDescription("<![CDATA[音乐描述>");
        mu.setHQMusicUrl("<![CDATA[HQ音乐路径>");
        mu.setMusicURL("<![CDATA[音乐路径>");
        mu.setThumbMediaId("<![CDATA[音乐缩略图>");
        WxMusicMessage music = new WxMusicMessage();
        music.setToUserName(map.get("FromUserName"));
        music.setFromUserName(map.get("ToUserName"));
        music.setCreateTime(map.get("CreateTime"));
        music.setMsgType(map.get("MsgType"));
        music.setMusic(mu);
        return convertToXml(music);
    }

    /**
     * TODO 待测试
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[news]]></MsgType>
     *   <ArticleCount>1</ArticleCount>
     *   <Articles>
     *     <item>
     *       <Title><![CDATA[title1]]></Title>
     *       <Description><![CDATA[description1]]></Description>
     *       <PicUrl><![CDATA[picurl]]></PicUrl>
     *       <Url><![CDATA[url]]></Url>
     *     </item>
     *   </Articles>
     * </xml>
     * @param map
     * @return
     */
    public static String initNewsMessage(Map<String, String> map) {
        Articles ar = new Articles();
        ar.setTitle("猫和老鼠");
        ar.setDescription("《猫和老鼠》以闹剧为特色，描绘了一对水火不容的冤家：汤姆和杰瑞猫鼠之间的战争，片中的汤姆经常使用狡诈的诡计来对付杰瑞，而杰瑞则时常利用汤姆诡计中的漏洞逃脱他的迫害并给予报复");
        // 图片链接
        ar.setPicUrl("https://mp.weixin.qq.com/s?_");
        ar.setUrl("https://image.baidu.com/search/index?tn=baiduimage&ct=201326592&lm=-1&cl=2&ie=gb18030&word=jerry&fr=ala&ala=1&alatpl=adress&pos=0&hs=2&xthttps=111111");
        List<Articles> articles = new ArrayList<>();
        articles.add(ar);
        WxNewsMessage news = new WxNewsMessage();
        news.setToUserName(map.get("FromUserName"));
        news.setFromUserName(map.get("ToUserName"));
        news.setCreateTime(map.get("CreateTime"));
        news.setMsgType("news");
        news.setArticleCount(String.valueOf(articles.size()));
        news.setArticles(articles);
        return convertToXml(news);
    }

}
