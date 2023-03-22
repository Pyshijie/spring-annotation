package com.ishijie;

import org.example.Main;
import org.example.aop.MainCaculator;
import org.example.config.SpringConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: com.ishijie
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-22  11:29
 *@Description: TODO
 *@Version: 1.0
 */
public class AOPTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                SpringConfigOfAOP.class
        );
        MainCaculator bean = applicationContext.getBean(MainCaculator.class);
        bean.div(10,0);

    }

}
