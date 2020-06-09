package com.wx.gzh.entity.msg;

/**
 * 微信发送/接收消息记录
 * @author JUNN
 * @since 2019/8/20 0020 下午 17:52
 */
public class WxMsg {
    private int id;
    private String uid;
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgId;
    private String MsgType;
    private Integer MsgSource;
    private String msgKey;
    private String release1;
    private String release2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public Integer getMsgSource() {
        return MsgSource;
    }

    public void setMsgSource(Integer msgSource) {
        MsgSource = msgSource;
    }

    public String getMsgKey() {
        return msgKey;
    }

    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
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

    public WxMsg() {
    }

    public WxMsg(String uid, String toUserName, String fromUserName, String createTime, String msgId, String msgType, Integer msgSource, String msgKey) {
        this.uid = uid;
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgId = msgId;
        MsgType = msgType;
        MsgSource = msgSource;
        this.msgKey = msgKey;
    }

    @Override
    public String toString() {
        return "WxMsg{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgId='" + MsgId + '\'' +
                ", MsgType=" + MsgType +
                ", MsgSource=" + MsgSource +
                ", msgForeignKey=" + msgKey +
                ", release1='" + release1 + '\'' +
                ", release2='" + release2 + '\'' +
                '}';
    }
}
