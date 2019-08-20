# 消息记录表(用户发送消息、用户接受消息)
drop table if exists wx_msg;
create table wx_msg(
    id int(32) not null primary key,
    uid int(32),
    ToUserName varchar(64) comment '开发者微信号',
    FromUserName varchar(64) comment '发送方帐号(一个OpenID)',
    CreateTime int comment '消息创建时间(整型)',
    MsgId int comment  '消息id，64位整型',
    MsgType int comment '消息类型',
    MsgSource int comment  '消息来源',
    msgForeignKey int(32) not null comment '外键',
    release1 varchar(32) comment '备用1',
    release2 varchar(32) comment '备用2'
) comment '消息记录表'