package com.ishijie;

import org.example.config.SpringConfigOfAware;
import org.example.entity.Blue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: com.ishijie
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-22  09:41
 *@Description: TODO
 *@Version: 1.0
 */
public class IOCTest_Aware {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigOfAware.class);

        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

        System.out.println(applicationContext);
    }

}
