package org.example.config;

import org.example.entity.LifeCycleBeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.config
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  15:59
 *@Description: TODO
 *@Version: 1.0
 */
@Configuration
@ComponentScan(basePackages = "org.example.entity")
public class SpringConfigOfLifeCycle {

    /**
     * bean生命周期: 从 初始化 -- 销毁
     *
     * 1. 首先调用无参构造创建bean实例
     * 2. 使用set方法完成属性的注入
     * 3. 在初始化方法执行之前调用BeanPostProcessor - postProcessBeforeInitialization
     * 4. 执行初始化方法
     * 5. 在初始化方法执行之后调用BeanPostProcessor - postProcessAfterInitialization
     * 6. 对象实例创建完毕
     * 7. 关闭容器，执行销毁方法
     *      7.1 如果是单例bean，会执行销毁方法
     *      7.2 如果是多例bean，不会执行销毁方法，需要手动调用。
     * */

    /*
    * 使用@Bean 指定初始化方法和销毁方法
    * */

    @Bean(initMethod = "init",destroyMethod = "destory")
    public LifeCycleBeanOne lifeCycleBeanOne(){
        return new LifeCycleBeanOne();
    }

    /**
     * 2.Bean 实现 IntializingBean 和 DisposableBean 来 指定初始化方法和销毁方法
     * 初始化方法 afterPropertiesSet
     * 销毁方法 destroy
     */

    /*
    *  3. 使用@PostConstruct 和 @Predestory 注解标注在bean的方法上，
    *     在初始化时会调用@PostConstruct标注的方法
    *     在销毁时会调用@PreDestroy 标注的方法
    * */

    /*
    *   BeanPostProcessor : 后置处理器,在初始化方法的前后会调用后置处理器中的方法
    *   Apply this BeanPostProcessor to the given new bean instance before any bean initialization callbacks (like InitializingBean's afterPropertiesSet or a custom init-method).
    *   postProcessBeforeInitialization
    *
    *   Apply this BeanPostProcessor to the given new bean instance after any bean initialization callbacks (like InitializingBean's afterPropertiesSet or a custom init-method).
    *   postProcessAfterInitialization
     *   注意： 只要注册了后置处理器，那么在任意一个类调用初始化方法的前后都会触发BeanPostProcessor中的方法
    * */




}
