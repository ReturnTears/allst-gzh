# 消息记录表(用户发送消息、用户接受消息)
drop table if exists wx_msg;
create table wx_msg(
    id int(32) not null primary key auto_increment,
    uid varchar(64),
    to_user_name varchar(64) comment '开发者微信号',
    from_user_name varchar(64) comment '发送方帐号(一个OpenID)',
    create_time int comment '消息创建时间(整型)',
    msg_id VARCHAR(32) comment  '消息id，64位整型',
    msg_type VARCHAR(32) comment '消息类型',
    msg_source int comment  '消息来源',
    msg_foreign_key bigint(64) not null comment '外键',
    release1 varchar(32) comment '备用1',
    release2 varchar(32) comment '备用2'
) comment '消息记录表';