# 微信公众号开发
    公司最近想在自己的系统上接入微信公众号，这里先做一个小DEMO
    系统接入微信公众号大致流程：
    1、在微信公众平台中申请微信公众号
    2、进入到个人微信公众号中，开发 - 开发者工具 - 开发者文档 ，里面有微信公众平台对接服务器开发的详细说明
    3、服务端接入微信公众平台服务，我这里采用的是内网穿透的方式，将我们本地的服务映射到外网中，这样就可以与微信服务端链接上
    4、编写服务端接入逻辑
    5、接入完成后，用户就可以和我们的服务端进行交互
    
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


### URl
    https://blog.csdn.net/daga_a/article/details/81511676

