package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.entity
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  19:54
 *@Description: TODO
 *@Version: 1.0
 */
@Component
public class Boss {


    private Car car;

    //@Autowired
    public Boss(Car car){
        this.car = car;
        System.out.println("调用了Boss的有参构造..");
        System.out.println(car);
    }

    public Car getCar() {
        return car;
    }

    //@Autowired
    public void setCar(/*@Autowired*/ Car car) {
        System.out.println("调用了Boss 的 setCar 方法");
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}


