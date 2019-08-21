# 消息内容存放表(地理位置消息)
drop table if exists wx_msg_location;
create table wx_msg_location(
     msg_foreign_key varchar(64) not null primary key,
     location__x double comment '地理位置维度',
     location__y double comment '地理位置经度',
     scale int comment '地图缩放大小',
     label varchar(256) comment '地理位置信息',
     release1 varchar(32) comment '备用1',
     release2 varchar(32) comment '备用2'
) comment '消息内容存放表(地理位置消息)';