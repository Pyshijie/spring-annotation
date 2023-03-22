package org.example.config;

import org.aspectj.lang.annotation.Aspect;
import org.example.Main;
import org.example.aop.LogAspects;
import org.example.aop.MainCaculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.config
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-22  11:05
 *@Description: TODO
 *@Version: 1.0
 */
@Configuration
@EnableAspectJAutoProxy


public class SpringConfigOfAOP {
    /*
    *  实现AOP功能的基本使用。AOP:面向切面编程 ：在不修改业务代码的前提下进行功能的一个完善
    *   0. 导入spring-aspects 依赖
    *   1. 需求：业务逻辑类(MainCaculator)
    *      在业务逻辑类的div方法调用运行时打印一些不同时间段对应的日志：
    *      如在div方法运行之前，输出方法名称信息和方法参数信息
    *      在div方法运行之后，输入方法名称信息和返回的结果
    *      在div方法出现异常之后，输出异常信息等等..
    *   2. 日志切面类(LogAspects) 在日志切面类中分别定义不同的方法，用于切入在业务逻辑方法执行的每一个时刻进行调用
    *   3. 此时就需要我们的LogAspects时刻动态的知道MainCaculator方法执行到什么时机了，根据不同的时机调用不同的方法
    *      当方法执行到指定时机的时候会通知日志切面类来执行相应的日志输出
    *      不同时机对应不同的通知：通知有以下几种类型
    *       1. 前置通知 (@Before) 业务逻辑方法div执行之前进行通知切面类指定相应的方法
    *       2. 后置通知 (@After) 业务逻辑方法div执行之后进行通知(无论是否出现异常都会执行)
    *       3. 最终通知 (@AfterReturning) 业务逻辑方法div正常执行之后进行通知
    *       4. 异常通知 (@AfterThrowing) 业务逻辑方法div出现异常之后进行通知
    *       5. 环绕通知 (@Around) 可以手动执行业务逻辑方法(ProceedingJoinPoint.proceed()) 最为强大
    *   4. 在日志切面类的方法上加上不同的通知注解，以及切入点表达式：告诉切面类那个逻辑方法执行到什么时候应该执行什么方法
    *       在日志切面类上添加@Aspect注解，告诉Spring那个是切面类，否则Spring无法识别那个是切面类
    *   5. 将日志切面类和业务逻辑类添加到IOC容器中，由Spring统一管理，如果不添加到IOC容器中，那么bean是无法使用Spring提供的强大的功能，比如AOP功能
    *   6. 开启基于注解的AOP @EnableAspectJAutoProxy 在配置类上进行标注
    * */

    @Bean
    public MainCaculator mainCaculator(){
        return new MainCaculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
