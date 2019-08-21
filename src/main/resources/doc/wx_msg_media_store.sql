# 消息内容存放表(多媒体消息内容)
drop table if exists wx_msg_media;
create table wx_msg_media(
     msgForeignKey int(32) not null primary key,
     PicUrl varchar(128) comment 'Image存放路径',
     MediaId varchar(128) comment '消息媒体id',
     Format varchar(32) comment '语音格式，如amr，speex等',
     ThumbMediaId varchar(128) comment '消息缩略图的媒体id',
     release1 varchar(32) comment '备用1',
     release2 varchar(32) comment '备用2'
) comment '消息内容存放表(多媒体消息内容)';