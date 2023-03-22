package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.entity.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.config
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-22  09:49
 *@Description: TODO
 *@Version: 1.0
 */
@Configuration
@PropertySource(value = "classpath:/jdbc.properties")
public class SpringConfigOfProfile implements EmbeddedValueResolverAware {
    /*
    * @Profile 注解很强大，可以根据指定的环境，来激活和切换一系列组件
    * 测试环境 test 开发环境 dev 生产环境 prod
    * 比如我们有三个环境对应三个数据源，我们通过指定不同的环境来加载不同的数据源
    * 没有被@Profile标注的Bean，任何环境下都会进行注入
    *
    * 比如我们的@Profile("test")标注的组件，会在test环境下进行注入，不是test环境下则不会进行注入
    *
    * 指定目标环境
    * 1. 配置JVM参数：-Dspring.profiles.active=test
    * 2. 在初始化容器时，使用无参构造函数，先进行对环境的设置，再加载主配置文件
    * applicationContext.getEnvironment().setActiveProfiles("test","dev");
    * */

    @Value("${jdbc.username}")
    private String username;

    private StringValueResolver stringValueResolver;

    @Bean
    @Profile("test")
    public DataSource dataSourceTest(@Value("${jdbc.password}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        String driverClassName = stringValueResolver.resolveStringValue("${jdbc.driverClassName}");
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    @Profile("dev")
    public DataSource dataSourceDev(@Value("${jdbc.password}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/dev");
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        String driverClassName = stringValueResolver.resolveStringValue("${jdbc.driverClassName}");
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    @Profile("prod")
    public DataSource dataSourceProd(@Value("${jdbc.password}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/prod");
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        String driverClassName = stringValueResolver.resolveStringValue("${jdbc.driverClassName}");
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public Car car(){
        return new Car();
    }


    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
    }
}
