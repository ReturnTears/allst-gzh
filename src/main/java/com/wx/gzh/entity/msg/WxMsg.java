package com.wx.gzh.entity.msg;

/**
 * 微信发送/接收消息记录
 * @author JUNN
 * @since 2019/8/20 0020 下午 17:52
 */
public class WxMsg {
    private int id;
    private int uid;
    private String ToUserName;
    private String FromUserName;
    private int CreateTime;
    private int MsgId;
    private int MsgType;
    private int MsgSource;
    private int msgForeignKey;
    private String release1;
    private String release2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
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

    public int getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(int createTime) {
        CreateTime = createTime;
    }

    public int getMsgId() {
        return MsgId;
    }

    public void setMsgId(int msgId) {
        MsgId = msgId;
    }

    public int getMsgType() {
        return MsgType;
    }

    public void setMsgType(int msgType) {
        MsgType = msgType;
    }

    public int getMsgSource() {
        return MsgSource;
    }

    public void setMsgSource(int msgSource) {
        MsgSource = msgSource;
    }

    public int getMsgForeignKey() {
        return msgForeignKey;
    }

    public void setMsgForeignKey(int msgForeignKey) {
        this.msgForeignKey = msgForeignKey;
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
}
