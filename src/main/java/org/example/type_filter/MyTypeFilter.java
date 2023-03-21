package org.example.type_filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.type_filter
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  09:15
 *@Description: TODO
 *@Version: 1.0
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * @description:
     * @author: yinxiaochao
     * @date: 2023/3/21 9:15
     * @param: [metadataReader] 读取到的当前正在扫描的类的信息
     * @param: [metadataReaderFactory] 可以获取到其他任何类的信息的（工厂）
     * @return: boolean
     **/
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 读取到当前正在扫描的类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 读取到当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 读取到当前正在扫描的类的资源
        Resource resource = metadataReader.getResource();
        System.out.println(" annotationMetadata = " + annotationMetadata);
        System.out.println(" classMetadata = " + classMetadata);
        System.out.println(" resource = " + resource);
        return false;
    }
}
