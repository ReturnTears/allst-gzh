# 消息内容存放表(文本消息)
drop table if exists wx_msg_content_store;
create table wx_msg_content_store(
    msgForeignKey int(32) not null primary key,
    content text comment '消息内容(消息类型为文本类型)',
    release1 varchar(32) comment '备用1',
    release2 varchar(32) comment '备用2'
) comment '消息内容存放表(文本消息)'