package com.wx.gzh.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 日期相关处理工具类
 * @author JUNN
 * @since 2019/8/22 0022 下午 15:00
 */
public class DateTimeUtil {

    /**
     * 据当前时间转换为10位时间戳格式
     * @return
     *              转换后10位时间戳格式
     */
    public static Integer Date2Timestamp() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return (int) ((timestamp.getTime()) / 1000);
    }

    public static Date Timestamp2Date(Integer timestamp){
        long time = (long) timestamp * 1000;
        Timestamp ts = new Timestamp(time);
        Date date = new Date();
        try {
            date = ts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /*public static void main(String[] args) {
        Integer a = Date2Timestamp();
        System.out.println(a);
        System.out.println(Timestamp2Date(a));
    }*/
}
