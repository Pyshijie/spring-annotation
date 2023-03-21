package com.ishijie;

import org.example.config.SpringConfig;
import org.example.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: com.ishijie
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  08:51
 *@Description: TODO
 *@Version: 1.0
 */
public class test {


    @Test
    public void test03(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        //Person bean = applicationContext.getBean(Person.class);
        //Person bean2 = applicationContext.getBean(Person.class);
        //System.out.println(bean == bean2);
    }

    @Test
    public void test02(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

}
