package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.config
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  18:42
 *@Description: TODO
 *@Version: 1.0
 */
@Configuration
@ComponentScan(basePackages = {"org.example.entity"})
public class SpringConfigOfValue {
}
