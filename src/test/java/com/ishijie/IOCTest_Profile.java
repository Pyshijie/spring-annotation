package com.ishijie;

import org.example.config.SpringConfigOfProfile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: com.ishijie
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-22  10:23
 *@Description: TODO
 *@Version: 1.0
 */
public class IOCTest_Profile {

    @Test
    public void test(){
        /*
        * public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
                this();
                register(componentClasses);
                refresh();
          }
        * */
        //AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        //        SpringConfigOfProfile.class
        //);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        applicationContext.register(SpringConfigOfProfile.class);
        applicationContext.refresh();
        Map<String, DataSource> beansOfType = applicationContext.getBeansOfType(DataSource.class);
        beansOfType.keySet().stream().forEach(System.out::println);
    }

}
