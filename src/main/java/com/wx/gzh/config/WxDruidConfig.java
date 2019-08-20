package com.wx.gzh.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Druid 配置类
 * @author  Junn
 * @since 2019/7/17 0017下午 13:57
 */
@Configuration
public class WxDruidConfig {

    /**
     * 注册过滤器Filter
     * @return
     *          filter
     */
    @Bean
    public FilterRegistrationBean setDruidFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.addUrlPatterns("/*");
        filter.setFilter(new WebStatFilter());
        Map<String, Object> initParamters = new HashMap<>();
        initParamters.put("exclusions", "*.js,*.html,*.gif,*.jpg,*.png,*.css,*.ico,*.jsp,/druid/*,/download/*");
        filter.setInitParameters(initParamters);
        return filter;
    }

    /**
     * 注册StatViewServlet
     * @return
     *          servletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean setDruidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");

        Map<String, Object> map = new HashMap<>();
        // 禁用HTML页面上的"Rest All"功能
        map.put("resetEnable", "false");
        // ip白名单（没有配置或者为空，则允许所有访问）
        map.put("allow", "");
        // 监控页面登陆用户名、密码
        map.put("loginUsername", "rooter");
        map.put("loginPassword", "456789");
        // ip黑名单(如果某个ip同时存在黑白名单，deny优先于allow)
        map.put("deny", "");
        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }

}
