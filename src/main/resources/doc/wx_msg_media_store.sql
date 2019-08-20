# 消息内容存放表(多媒体消息内容)
drop table if exists wx_msg_store;
create table wx_msg_store(
     msgForeignKey int(32) not null primary key,
     multimedia varchar(128) comment '多媒体消息内容存放路径',
     release1 varchar(32) comment '备用1',
     release2 varchar(32) comment '备用2'
) comment '消息内容存放表(多媒体消息内容)'