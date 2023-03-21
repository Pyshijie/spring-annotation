package org.example.entity;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.entity
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  16:04
 *@Description: TODO
 *@Version: 1.0
 */
public class LifeCycleBeanOne {

    public LifeCycleBeanOne(){
        System.out.println("LifeCycleBeanOne... constructor...");
    }

    public void init(){
        System.out.println("LifeCycleBeanOne... init...");
    }

    public void destory(){
        System.out.println("LifeCycleBeanOne... destory...");
    }

}
