package org.example.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.condition
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  09:29
 *@Description: TODO
 *@Version: 1.0
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // ConditionContext  条件上下文，ConditionContext接口类型的，可以用来获取容器中上下文信息
        // AnnotatedTypeMetadata  用来获取被@Conditional标注的对象上的所有注解信息

        // 获取ioc bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 获取BeanDefinitionRegistry,可以来注册bean,也可以来获取bean等等..
        BeanDefinitionRegistry registry = context.getRegistry();
        // 获取当前容器环境信息
        Environment environment = context.getEnvironment();
        // 获取资源加载器
        ResourceLoader resourceLoader = context.getResourceLoader();
        if (environment.getProperty("os.name").contains("Windows")){
            return true;
        }
        return false;
    }
}
