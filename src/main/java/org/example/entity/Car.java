package org.example.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.entity
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  16:14
 *@Description: TODO
 *@Version: 1.0
 */
@Component
public class Car {

    public Car(){
        System.out.println("Car ... constructor...");
    }

    @PostConstruct
    public void init(){
        System.out.println("Car ... @PostConstruct...");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Car ... @PreDestory...");
    }

}
