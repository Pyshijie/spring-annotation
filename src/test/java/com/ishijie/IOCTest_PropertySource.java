package com.ishijie;

import org.example.config.SpringConfigOfValue;
import org.example.entity.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: com.ishijie
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  18:40
 *@Description: TODO
 *@Version: 1.0
 */

public class IOCTest_PropertySource {

    private AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigOfValue.class);

    @Test
    public void test01(){
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
    }

}
