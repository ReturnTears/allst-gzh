# 用户信息表
drop table if exists wx_user_info;
create table wx_user_info(
  id int(32) not null primary key,
  uid int(32),
  subscribe char comment '用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。',
  openid varchar(32) comment '用户的标识，对当前公众号唯一',
  nickname varchar(32) comment '用户的昵称',
  sex char comment '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  language varchar(32) comment '用户的语言，简体中文为zh_CN',
  city varchar(32) comment '用户所在城市',
  province varchar(32) comment '用户所在省份',
  country varchar(32) comment '用户所在国家',
  headimgurl varchar(255) comment '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
  subscribe_time datetime comment '用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间',
  unionid varchar(64) comment '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。',
  remark text comment '公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注',
  groupid smallint(10) comment '用户所在的分组ID（兼容旧的用户分组接口）',
  tagid_list varchar(255) comment '用户被打上的标签ID列表',
  subscribe_scene varchar(32) comment '返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他',
  qr_scene varchar(64) comment '二维码扫码场景（开发者自定义）',
  qr_scene_str varchar(255) comment '二维码扫码场景描述（开发者自定义）',
  isdelete char comment '是否删除',
  createTime datetime comment '编辑时间',
  release1 varchar(32) comment '备用1',
  release2 varchar(32) comment '备用2'
) comment '用户信息表'

#