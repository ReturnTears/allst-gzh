package com.wx.gzh.utils;

import com.wx.gzh.constant.CommEnum;
import com.wx.gzh.entity.msg.WxMsg;
import com.wx.gzh.entity.user.WxUserInfo;
import net.sf.json.JSONObject;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Map;

/**
 * 将JSON对象转换为实体类
 * @Auther Junn
 * @Date 2019/7/17 0017下午 16:04
 */
public class JsonToClass {
    /**
     * 方式1  -   toBean方法
     * JSON转换为WxUserInfo实体类
     * @param jsonStr
     *                  json字符串
     * @return
     *                  WxUserInfo对象
     */
    public WxUserInfo jsonToUserInfo(String jsonStr) {
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        WxUserInfo userInfo = (WxUserInfo) JSONObject.toBean(jsonObject, WxUserInfo.class);
        return userInfo;
    }

    /**
     * 方式2  -   手动封装
     * JSON对象转换为WxUserInfo实体类
     * @param jsonStr
     *                  json字符串
     * @return
     *                  WxUserInfo对象
     */
    public WxUserInfo jsonToWxUserInfo(String jsonStr) {
        JSONObject jsonObject =  JSONObject.fromObject(jsonStr);
        WxUserInfo userInfo = new WxUserInfo();
        userInfo.setSubscribe(jsonObject.getInt("subscribe"));
        userInfo.setOpenid(jsonObject.getString("openid"));
        userInfo.setNickname(jsonObject.getString("nickname"));
        userInfo.setSex(jsonObject.getInt("sex"));
        userInfo.setLanguage(jsonObject.getString("language"));
        userInfo.setCity(jsonObject.getString("city"));
        userInfo.setProvince(jsonObject.getString("province"));
        userInfo.setCountry(jsonObject.getString("country"));
        userInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
        userInfo.setSubscribe_time(jsonObject.getLong("subscribe_time"));
        //userInfo.setUnionid(jsonObject.getString("unionid"));
        userInfo.setRemark(jsonObject.getString("remark"));
        userInfo.setGroupid(jsonObject.getInt("groupid"));
        userInfo.setTagid_list(jsonObject.get("tagid_list"));
        userInfo.setSubscribe_scene(jsonObject.getString("subscribe_scene"));
        userInfo.setQr_scene(jsonObject.getString("qr_scene"));
        userInfo.setQr_scene_str(jsonObject.getString("qr_scene_str"));
        return userInfo;
    }

    /**
     * 将Map集合封装为JavaBean实体对象
     * @param map
     *                  map集合数据
     * @return
     *                  实体对象
     */
    public static <T> T mapToWxMsg(Map<String, String> map, Class<T> classType) throws Exception {
        //  采用反射动态创建对象
        T obj = classType.newInstance();
        // 获取对象字节码信息,不要Object的属性
        BeanInfo beanInfo = Introspector.getBeanInfo(classType, Object.class);
        // 获取bean对象中的所有属性
        PropertyDescriptor[] list = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : list) {
            // 获取属性名
            String key = pd.getName();
            // 获取属性值
            String value = map.get(key);
            // 调用属性setter()方法,设置到javabean对象当中
            pd.getWriteMethod().invoke(obj, value);
        }
        return obj;
    }
}
