package org.example.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
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
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        if (environment.getProperty("os.name").contains("linux")){
            return true;
        }
        return false;
    }
}
