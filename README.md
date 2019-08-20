# 微信公众号开发
    公司最近想在自己的系统上接入微信公众号，这里先做一个小DEMO
    系统接入微信公众号大致流程：
    1、在微信公众平台中申请微信公众号
    2、进入到个人微信公众号中，开发 - 开发者工具 - 开发者文档 ，里面有微信公众平台对接服务器开发的详细说明
    3、服务端接入微信公众平台服务，我这里采用的是内网穿透的方式，将我们本地的服务映射到外网中，这样就可以与微信服务端链接上
    4、编写服务端接入逻辑
    5、接入完成后，用户就可以和我们的服务端进行交互
    6、消息的被动回复
    7、图灵聊天机器人
    8、token的获取
    9、菜单的封装
    10、二维码的生成
    11、获取用户信息
    12、网页授权
    13、新增素材
    14、收集用户信息数据
    
## 消息类型
### 文本消息
    ToUserName	    开发者微信号
    FromUserName	    发送方帐号（一个OpenID）
    CreateTime	    消息创建时间 （整型）
    MsgType	            消息类型，文本为text
    Content	            文本消息内容
    MsgId	            消息id，64位整型

### 图片消息
    ToUserName	    开发者微信号
    FromUserName	    发送方帐号（一个OpenID）
    CreateTime	    消息创建时间 （整型）
    MsgType	            消息类型，图片为image
    PicUrl	            图片链接（由系统生成）
    MediaId	            图片消息媒体id，可以调用获取临时素材接口拉取数据。
    MsgId	            消息id，64位整型

### 语音消息
    ToUserName	    开发者微信号
    FromUserName	    发送方帐号（一个OpenID）
    CreateTime	    消息创建时间 （整型）
    MsgType	            语音为voice
    MediaId	            语音消息媒体id，可以调用获取临时素材接口拉取数据。
    Format	            语音格式，如amr，speex等
    MsgID	            消息id，64位整型

### 视频消息
    ToUserName	    开发者微信号
    FromUserName	    发送方帐号（一个OpenID）
    CreateTime	    消息创建时间 （整型）
    MsgType	            视频为video
    MediaId	            视频消息媒体id，可以调用获取临时素材接口拉取数据。
    ThumbMediaId	    视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    MsgId	            消息id，64位整型

### 小视频消息
    ToUserName	    开发者微信号
    FromUserName	    发送方帐号（一个OpenID）
    CreateTime	    消息创建时间 （整型）
    MsgType	            小视频为shortvideo
    MediaId	            视频消息媒体id，可以调用获取临时素材接口拉取数据。
    ThumbMediaId	    视频消息缩略图的媒体id，可以调用获取临时素材接口拉取数据。
    MsgId	            消息id，64位整型

### 地理位置消息
    ToUserName	    开发者微信号
    FromUserName	    发送方帐号（一个OpenID）
    CreateTime	    消息创建时间 （整型）
    MsgType	            消息类型，地理位置为location
    Location_X	    地理位置维度
    Location_Y	    地理位置经度
    Scale	            地图缩放大小
    Label	            地理位置信息
    MsgId	            消息id，64位整型

### 链接消息
    ToUserName	    接收方微信号
    FromUserName	    发送方微信号，若为普通用户，则是一个OpenID
    CreateTime	    消息创建时间
    MsgType	            消息类型，链接为link
    Title	            消息标题
    Description	    消息描述
    Url	            消息链接
    MsgId	            消息id，64位整型

### 图文消息
    

### URL
    https://image.baidu.com/search/index?tn=baiduimage&amp;ct=201326592&amp;lm=-1&amp;cl=2&amp;ie=gb18030&amp;word=jerry&amp;fr=ala&amp;ala=1&amp;alatpl=adress&amp;pos=0&amp;hs=2&amp;xthttps=111111


### robot
    聊天机器人采用图灵机器人的api接口
    **使用说明**
    编码方式
    UTF-8（调用图灵API的各个环节的编码方式均为UTF-8）
    接口地址
    http://openapi.tuling123.com/openapi/api/v2
    请求方式
    HTTP	POST
    请求参数
    请求参数格式为 json
    

### 项目结构指南
    annotation  注解包
    api         与微信服务器的链接URL所在包
    constant    所有常量包
    model       model类
    robot       聊天机器人
    service     服务层
    tools       工具包(包括：消息、事件...)
    utils       所有工具类(包括: 工具类、公共类、公共方法...)
    web         与页面映射的链接URL所在包
    static      静态资源
    templates   页面模板

### importance
    页面路径的配置放在配置文件中  或者存放在数据库中，再写一个页面来维护数据， 更倾向于第一种方式，（也可以将配置放在微信公众号中权限交由管理员来完成）
    先实现第一种，后面完成数据库维护的方式
    
### OAuth2.0
```
微信OAuth2.0授权

OAuth2.0的处理流程:

    1 第一步：用户同意授权，获取code
    
    2 第二步：通过code换取网页授权access_token
    
    3 第三步：刷新access_token（如果需要）
    
    4 第四步：拉取用户信息(需scope为 snsapi_userinfo)
    
    5 附：检验授权凭证（access_token）是否有效 

授权的两种方式:
    
    静默授权: 用户是无感知的
    
    显示授权



```

### 收集用户信息数据

### 整合MyBatis框架
    Mybatis1.3.1 + MySQL8.0

### 公众号的视图结构
    一级菜单    二级菜单
    菜单一      公司简介、项目案例、其他、关于我们、公司招聘
    菜单二      接入现有项目

### 公司简介页面
    跳转公司官网地址
### 项目案例页面
    跳转公司案例地址

### 备注
```
$xslt
Navicat连接MySQL Server8.0版本时出现Client does not support authentication protocol requested  by server；解决如下：
1、use mysql;

2、alter user 'root'@'localhost' identified with mysql_native_password by 'your password';

3、flush privileges;

```
        
