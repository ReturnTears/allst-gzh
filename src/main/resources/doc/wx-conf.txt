package com.wx.gzh.constant;

/**
 * 常量类
 * @author JUNN
 * @since 2019/6/24 0024下午 14:48
 */
public class Constant {
    /**
     * --------------------------------------------------接口配置信息-----------------------------------------------------
     */
     /**
     * TOKEN
      * hyj
      * puskeR
     */
    public static final String TOKEN = "puskeR";
    /**
     * URL
     * http://huwx.free.idcfengye.com/api/join
     * http://psk.free.idcfengye.com/api/join
     * http://psk.free.idcfengye.com/wx/api/join
     */
    public static final String URL = "http://huwx.free.idcfengye.com/join/wx";
    /**
     * --------------------------------------------------公众号信息------------------------------------------------------
     */
    /**
     * wxd8dc984917fefba0
     *  APPID
     *  wx8299f35093a90fae  正式  /   wx68c1e110faa97e7b 测试
     */
    public static final String APPID = "wx5afdca70cc4f5c3d";
    /**
     * 3950c17dacd4db2dbfc7bc7c06957cae
     * APPSECRET
     *  2e2bff396759fcb534a5fee8e72622f8  正式  /   747eb4b85b9371695cef0ae96a6559f0  测试
     *  EncodingAESKey: 正式
     *  IwfiVcUUeZdnbtaDrT2EvKSNKu69F6kXa6Z704h3G53
     */
    public static final String APPSECRET = "19d1ee0279364f90b3d271b9f531f878";
    /**
     * ----------------------------------------------ACCESS_TOKEN-------------------------------------------------------
     *
     *  通过APPID和APPSECRET获取ACCESS_TOKEN的接口地址
     */
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 通过ACCESS_TOKEN创建公众号菜单的接口地址
     */
    public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**
     * 通过ACCESS_TOKEN删除公众号菜单接口地址
     */
    public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    /**
     * 通过ACCESS_TIKEN获取公众号菜单接口地址
     */
    public static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

    /**
     * --------------------------------------------------二维码信息------------------------------------------------------
     */
    /**
     *  微信二维码 (临时二维码可以生成较多数量 / 永久二维码可以生成最多10W个)
     */
    public static final String WX_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
    /**
     * 通过ticket换取二维码, 提醒：TICKET记得进行UrlEncode
     */
    public static final String WX_TICKET_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
    /**
     * --------------------------------------------------二维码类型------------------------------------------------------
     */
    /**
     * QR_SCENE为临时的整型参数值
     */
    public static final String QR_SCENE = "QR_SCENE";
    /**
     * QR_STR_SCENE为临时的字符串参数值
     */
    public static final String QR_STR_SCENE = "QR_STR_SCENE";
    /**
     * QR_LIMIT_SCENE为永久的整型参数值
     */
    public static final String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";
    /**
     * QR_LIMIT_STR_SCENE为永久的字符串参数值
     */
    public static final String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";
    /**
     * --------------------------------------------------系统参数--------------------------------------------------------
     */
    public static final String TMPDIR = System.getProperty("java.io.tmpdir");

    /**
     * ------------------------------------------------获取用户基本信息---------------------------------------------------
     */
    public static final String WX_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    /**
     *  批量获取用户基本信息, http请求方式: POST
     */
    public static final String WX_BATCH_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";

    /**
     * ------------------------------------------------主动推送信息接口---------------------------------------------------
     */
    public static final String WX_SEND_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";

    /**
     * --------------------------------------------------模板消息接口-----------------------------------------------------
     * 发送模板消息, http请求方式: POST
     */
    public static final String WX_TEMPLATE_MSG_SEND = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    /**
     * 设置所属行业, http请求方式: POST
     */
    public static final String WX_TEMPLATE_MSG_SET_INDUSTRY = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
    /**
     * 获取设置的行业信息, http请求方式：GET
     */
    public static final String WX_TEMPLATE_MSG_GET_INDUSTRY = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
    /**
     * 获得模板ID, http请求方式: POST
     */
    public static final String WX_TEMPLATE_MSG_ID = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
    /**
     * 获取模板列表, http请求方式：GET
     */
    public static final String WX_TEMPlATE_MSG_LIST = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
    /**
     * 删除模板, http请求方式：POST
     */
    public static final String WX_TEMPLATE_MSG_DELETE = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";

    /**
     * -----------------------------------------------用户关注的渠道来源--------------------------------------------------
     */
    /**
     * 公众号搜索
     */
    public static final String ADD_SCENE_SEARCH = "ADD_SCENE_SEARCH";
    /**
     * 公众号迁移
     */
    public static final String ADD_SCENE_ACCOUNT_MIGRATION = "ADD_SCENE_ACCOUNT_MIGRATION";
    /**
     * 扫描二维码
     */
    public static final String ADD_SCENE_QR_CODE = "ADD_SCENE_QR_CODE";
    /**
     * 名片分享
     */
    public static final String ADD_SCENE_PROFILE_CARD = "ADD_SCENE_PROFILE_CARD";
    /**
     * 图文页内名称点击
     */
    public static final String ADD_SCENEPROFILE_LINK = "ADD_SCENEPROFILE_LINK";
    /**
     * 图文页右上角菜单
     */
    public static final String ADD_SCENE_PROFILE_ITEM = "ADD_SCENE_PROFILE_ITEM";
    /**
     * 支付后关注
     */
    public static final String ADD_SCENE_PAID = "ADD_SCENE_PAID";
    /**
     * 其他
     */
    public static final String ADD_SCENE_OTHERS = "ADD_SCENE_OTHERS";

    /**
     * -----------------------------------------------微信网页授权--------------------------------------------------------
     */
    /**
     * 用户同意授权，获取Code
     */
    public static final String WX_OAuth2_Code = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    /**
     * 通过code换取网页授权access_token, 此access_token与基础支持的access_token不同
     */
    public static final String WX_OAuth2_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    /**
     * 刷新access_token（如果需要）
     */
    public static final String WX_OAuth2_REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
    /**
     * 检验授权凭证（access_token）是否有效, GET请求
     */
    public static final String WX_OAuth2_CHECK_TOKEN = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     */
    public static final String Wx_OAuth2_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    /**
     * 以snsapi_base为scope发起的网页授权，是用来获取进入页面的用户的openid的，并且是静默授权并自动跳转到回调页的。
     */
    public static final String WX_SNSAPI_BASE = "snsapi_base";
    /**
     * 以snsapi_userinfo为scope发起的网页授权，是用来获取用户的基本信息的
     */
    public static final String WX_SNSAPI_USERINFO = "snsapi_userinfo";

    /**
     * -----------------------------------------------素材管理-----------------------------------------------------------
     */
    /**
     * 新增临时素材
     */
    public static final String MATTER_ADD_TEMP = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    /**
     * 获取临时文件
     */
    public static final String MATTER_GET_TEMP = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
    /**
     * 新增永久文件
     */
    public static final String MATTER_ADD_PERM = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
    /**
     * 获取永久文件
     */
    public static final String MATTER_GET_PERM = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
    /**
     * 删除永久文件
     */
    public static final String MATTER_DEL_PERM = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
    /**
     * 修改永久文件
     */
    public static final String MATTER_UPDATE_PERM= "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
    /**
     * 获取素材总数
     */
    public static final String MATTER_NUMS = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
    /**
     * 获取素材列表
     */
    public static final String MATTER_LIST = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";

    /**
     * -----------------------------------------------图灵机器人---------------------------------------------------------
     */
    /**
     * 配置您申请的KEY
     */
    public static final String APIKEY = "6ad46dd0a00a400282a8d70b2b0faba9";
    /**
     * 接口地址
     */
    public static final String APIURL = "http://openapi.tuling123.com/openapi/api/v2";
    /**
     * 用户id
     */
    public static final String USERID = "469240";

    /**
     * --------------------------------------------------聚合数据机器人---------------------------------------------------
     */
    /**
     * 编码方式
     */
    public static final String DEF_CHATSET = "UTF-8";
    /**
     * 链接超时
     */
    public static final int DEF_CONN_TIMEOUT = 30000;
    /**
     * 读取超时
     */
    public static final int DEF_READ_TIMEOUT = 30000;
    /**
     * UserAgent
     */
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    /**
     * -------------------------------------------------消息 Message-----------------------------------------------------
     */
    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE="image";

    /**
     * 请求消息类型：语音
     */
    public static final String REQ_MESSAGE_TYPE_VOICE="voice";

    /**
     * 请求消息类型：视频
     */
    public static final String REQ_MESSAGE_TYPE_VIDEO="video";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static  final String REQ_MESSAGE_TYPE_LOCATION="location";

    /**
     * 请求消息类型：小视频
     */
    public static final String REQ_MESSAGE_TYPE_SHORTVIDEO="shortvideo";

    /**
     *请求消息类型：事件推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 消息返回类型：图片
     */
    public static final String RESP_MESSAGE_TYPE_IMAGE="image";

    /**
     * 消息返回类型:语音
     */
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 消息返回类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 消息返回类型：图文
     */
    public static final  String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 消息返回类型：视频
     */
    public static final String RESP_MESSAGE_TYPE_VIDEO="video";

    /**
     * --------------------------------------------------------事件 Event------------------------------------------------
     */
    /**
     * 事件类型:订阅
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：取消订阅
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：scan(关注用户扫描带参二维码)
     */
    public static final String EVENT_TYPE_SCAN = "scan";

    /**
     * 事件类型：location(上报地理位置)
     */
    public static final String EVENT_TYPE_LOCATION = "location";

    /**
     * 事件类型：CLICK(点击菜单拉取消息)
     */
    public static final String EVENT_TYPE_CLICK ="CLICK";

    /**
     * 事件类型：VIEW(自定义菜单URl视图)
     */
    public static final String EVENT_TYPE_VIEW ="VIEW";

    /**
     * 事件类型：TEMPLATESENDJOBFINISH(模板消息送达情况提醒)
     */
    public static final String EVENT_TYPE_TEMPLATESENDJOBFINISH="TEMPLATESENDJOBFINISH";
}
