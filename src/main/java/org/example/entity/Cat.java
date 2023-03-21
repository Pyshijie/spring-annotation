package org.example.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.entity
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  16:09
 *@Description: TODO
 *@Version: 1.0
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("Cat ... constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Cat ... destory()...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat ... afterPropertiesSet()...");
    }
}
