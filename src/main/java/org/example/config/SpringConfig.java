package org.example.config;

import org.example.condition.LinuxCondition;
import org.example.condition.WindowsCondition;
import org.example.entity.Book;
import org.example.entity.Person;
import org.example.type_filter.MyTypeFilter;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.config
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  08:55
 *@Description: TODO
 *@Version: 1.0
 */
@Configuration // 配置文件注解，声明这是配置文件替代原来的xml文件
@ComponentScan( // 扫描包注解
        basePackages = {"org.example"}, //扫描那个包
        includeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Person.class})
        },
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Repository.class, Service.class}),
            //@ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        },
        useDefaultFilters = false
)
/*
*  includeFilters : 根据指定规则只包含某些组件
*  excludeFilters : 根据指定规则排除组件，即不将次组件加入到ioc容器中
*  @Filter：配置过滤规则
*      type = FilterType.ANNOTATION 按照注解进行包含或者排除 例如：
*      includeFilters : @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}) 包含带有Controller注解的组件
*      type = FilterType.ASSIGNABLE_TYPE 按照给定的类型进行包含或者排除
*      excludeFilters : @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Repository.class, Service.class}) 排除带有Repository和 Service注解的类
*      type = FilterType.ASPECTJ 按照ASPECTJ表达式进行包含或者排除
*      tyoe = FilterType.REGEX 按照正则表达式进行包含或者排除
*      type = FilterType.CUSTOM 按照自定义规则进行包含或者排除
*
* 注意： 需要取消@ComponentScan的默认过滤器，这样我们配置的这些过滤器才能生效  useDefaultFilters = false
* */
@Import(value = {Book.class}) //快速导入Book组件,在容器默认的名字为类的全类名
public class SpringConfig {

    @Bean
    /*
    * ConfigurableBeanFactory.SCOPE_PROTOTYPE,  多例模式 , 获取多少次该bean，就创建多少次bean
    * ConfigurableBeanFactory.SCOPE_SINGLETON,  单例模式 ,容器中自始至终只有这一个单例bean，无论获取多少次该bean，返回的总是哪一个bean
    * org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST, 请求域
    * org.springframework.web.context.WebApplicationContext.SCOPE_SESSION  session域
    * */
    //@Scope(scopeName = "singleton") 单例模式，在初始化ioc容器时就会创建bean并将其加入到ioc容器中，自始至终只有这一个单例bean
    //@Scope(scopeName = "prototype") 多例模式, 获取几次bean就会创建几次bean，在初始化ioc容器时不会进行创建
    // 默认是singleton模式
    // 懒加载，主要是单例bean，在我们没有获取的时候我们不希望创建该bean，因此需要懒加载
    @Lazy // 懒加载注解
    public Person person(){
        System.out.println("创建了person bean...");
        return new Person("lisi",23);
    }

    // @Conditional 有条件的注册bean到ioc容器中
    // 	/**
    //	 * All {@link Condition Conditions} that must {@linkplain Condition#matches match}
    //	 * in order for the component to be registered.
    //	 */
    //	Class<? extends Condition>[] value();
    @Bean("bill")
    @Conditional(value = {WindowsCondition.class})
    public Person windows(){
        return  new Person("bill",64);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean("linus")
    public Person linux(){
        return new Person("linus",50);
    }

}
