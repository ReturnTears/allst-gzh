package com.wx.gzh.entity.msg;

/**
 * @author JUNN
 * @since 2019/8/20 0020 下午 18:05
 */
public class WxMsgLink {
    private Integer id;
    private String Title;
    private String Description;
    private String Url;
    private String msgId;
    private String release1;
    private String release2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getRelease1() {
        return release1;
    }

    public void setRelease1(String release1) {
        this.release1 = release1;
    }

    public String getRelease2() {
        return release2;
    }

    public void setRelease2(String release2) {
        this.release2 = release2;
    }

    @Override
    public String toString() {
        return "WxMsgLink{" +
                "id='" + id + '\'' +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Url='" + Url + '\'' +
                ", msgId='" + msgId + '\'' +
                ", release1='" + release1 + '\'' +
                ", release2='" + release2 + '\'' +
                '}';
    }
}
