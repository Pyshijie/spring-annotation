package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.aop
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-22  11:06
 *@Description: TODO
 *@Version: 1.0
 */
@Aspect
public class LogAspects {

    // 提取公共切入点
    @Pointcut("execution(public int org.example.aop.MainCaculator.*(..))")
    public void pointCut(){};

    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "执行之前 @Before 参数为: {" + Arrays.asList(joinPoint.getArgs()) + "}");
    }

    @After(value = "pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "执行之后 @After 参数为: {" + Arrays.asList(joinPoint.getArgs()) + "}");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    // returning 告诉spring方法中的那个变量用来接收结果
    public void logReturning(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName() + "正常执行之后 @AfterReturning 结果为: {" + result + "}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    // returning 告诉spring方法中的那个变量用来接收结果
    public void logThrowing(JoinPoint joinPoint,Exception ex){
        System.out.println(joinPoint.getSignature().getName() + "出现异常 @AfterThrowing 结果为: {" + ex + "}");
    }

    //@Around(value = "pointCut()")
    //public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    //    System.out.println("方法执行之前...");
    //    joinPoint.proceed();
    //    System.out.println("方法执行之后...");
    //}


}
