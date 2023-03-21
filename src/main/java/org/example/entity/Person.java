package org.example.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.entity
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  08:49
 *@Description: TODO
 *@Version: 1.0
 */
@PropertySource(value = {"classpath:/person.properties"},encoding = "UTF-8")
@Component
public class Person {

    /*
    * @Value注解支持一下形式的value值
    * 1.基本数据类型
    * 2.SPEL表达式 #{SPEL}
    * 3.peoperties文件获取值 ${属性}
    * */
    @Value("张三")
    private String name;
    @Value("#{20 - 2}")
    private Integer age;

    @Value("${person.nikeName}")
    private String nikeName;
    public Person(String name, Integer age,String nikeName) {
        this.name = name;
        this.age = age;
        this.nikeName = nikeName;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
