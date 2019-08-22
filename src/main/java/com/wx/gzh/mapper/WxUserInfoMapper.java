package com.wx.gzh.mapper;

import com.wx.gzh.entity.user.WxUserInfo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
 * UserInfo Mapper
 * @author  Junn
 * @since 2019/7/17 0017上午 11:05
 */
public interface WxUserInfoMapper extends Mapper<WxUserInfo> {

    @Select("select * from wx_user_info userInfo where userInfo.nickname = #{nickname}")
    Map<String, Object> selectUserInfo(Map<String, Object> params);

}
