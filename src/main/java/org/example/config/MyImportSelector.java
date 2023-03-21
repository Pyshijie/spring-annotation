package org.example.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.config
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  15:44
 *@Description: TODO
 *@Version: 1.0
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // importingClassMetadata 标注该@Impror的类的其它的注解信息
        return new String[]{"org.example.entity.Blue","org.example.entity.Yellow"};
    }
}
