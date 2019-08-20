# 消息内容存放表(链接消息)
drop table if exists wx_msg_link_store;
create table wx_msg_link_store(
    msgForeignKey int(32) not null primary key,
    Title varchar(64) comment '消息标题',
    Description varchar(256) comment  '消息描述',
    Url varchar(512) comment '消息链接',
    release1 varchar(32) comment '备用1',
    release2 varchar(32) comment '备用2'
) comment '消息内容存放表(链接消息内容)'