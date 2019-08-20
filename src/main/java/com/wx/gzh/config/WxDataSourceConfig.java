package com.wx.gzh.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * DataSource配置类
 * @author  Junn
 * @since 2019/7/17 0017上午 10:43
 */
@Configuration
@MapperScan(basePackages = {WxDataSourceConfig.MAPPER_PACKAGE}, sqlSessionFactoryRef = "baseSqlSessionTemplate")
public class WxDataSourceConfig {

    protected final static String MAPPER_XML_AREA = "classpath:mappers/*.xml";

    protected final static String MAPPER_PACKAGE = "com.wx.gzh.mapper";

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    /**
     * 注入DataSource数据源
     * @return
     *          DataSource
     */
    //@Primary
    @Bean(name = "baseDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource setDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 添加druid监控stat
        try {
            dataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  dataSource;
    }

    /**
     * 注入事务
     * @return
     *          Transaction
     */
    //@Primary
    @Bean(name = "baseTransationManager")
    public DataSourceTransactionManager setTransactionManager() {
        return new DataSourceTransactionManager(setDataSource());
    }

    /**
     * 注入SqlSession
     * @return
     *                  SqlSessionFactory
     * @throws Exception
     *                  Exception
     */
    //@Primary
    @Bean(value = "baseSqlSessionTemplate")
    public SqlSessionFactory setSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(setDataSource());
        // mapper.xml扫描路径
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_AREA));
        return sessionFactoryBean.getObject();
    }


}
