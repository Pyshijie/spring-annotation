package com.ishijie;

import org.example.aop.MainCaculator;
import org.example.config.SpringConfigOfAOP;
import org.example.config.TxConfig;
import org.example.tx.UserService;
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
public class TxTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                TxConfig.class
        );
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insert();
    }

}
