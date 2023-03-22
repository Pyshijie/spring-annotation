package org.example.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.entity
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  15:44
 *@Description: TODO
 *@Version: 1.0
 */
@Component
public class Blue implements ApplicationContextAware, EmbeddedValueResolverAware, EnvironmentAware, BeanFactoryAware {

    private ApplicationContext applicationContext;

    private String mess;

    private Boss boss;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("通过ApplicationContextAware 获取到的applicationContext = " + applicationContext);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String mess = resolver.resolveStringValue("我是${os.name},今年#{20 * 18}");
        this.mess = mess;
        System.out.println("通过EmbeddedValueResolver 解析的mess = " + mess);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        Boss bean = beanFactory.getBean(Boss.class);
        this.boss = bean;
        System.out.println("通过BeFactoryAware获取到的Boss bean = " + bean);

    }

    @Override
    public void setEnvironment(Environment environment) {
        String property = environment.getProperty("os.name");
        System.out.println("通过EnvironmentAware获取到的environment的os.name = " + property);
    }

    @Override
    public String toString() {
        return "Blue{" +
                "applicationContext=" + applicationContext +
                ", mess='" + mess + '\'' +
                ", boss=" + boss +
                '}';
    }
}
