package org.example.entity;

import org.springframework.beans.factory.FactoryBean;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.entity
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  15:52
 *@Description: TODO
 *@Version: 1.0
 */
public class RedFactoryBean implements FactoryBean<Red> {
    @Override
    public Red getObject() throws Exception {
        return new Red();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        // 指定生产的是单例bean还是多例bean,true为单例bean，false为多例bean
        return true;
    }
}
