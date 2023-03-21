package org.example.config;

import org.example.entity.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.config
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  15:48
 *@Description: TODO
 *@Version: 1.0
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // importingClassMetadata 扫描到当前类的注解信息
        // BeanDefinitionRegistry 注册bean中心
        // 可以自己指定名字。
        registry.registerBeanDefinition("rainBow",new RootBeanDefinition(RainBow.class));
    }
}
