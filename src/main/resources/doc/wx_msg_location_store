# 消息内容存放表(地理位置消息)
drop table if exists wx_msg_content_store;
create table wx_msg_content_store(
     msgForeignKey int(32) not null primary key,
     Location_X double comment '地理位置维度',
     Location_Y double comment '地理位置经度',
     Scale int comment '地图缩放大小',
     Label varchar(128) comment '地理位置信息',
     release1 varchar(32) comment '备用1',
     release2 varchar(32) comment '备用2'
) comment '消息内容存放表(地理位置消息)'