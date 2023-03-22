package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.config
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-22  09:28
 *@Description: TODO
 *@Version: 1.0
 */
@Configuration
@ComponentScan(basePackages = {"org.example.entity"})
public class SpringConfigOfAware {

    /*
    *   如果我们想要在我们的bean中注入Spring底层组件，比如StringValueResolver 或者 ApplicationContext组件
    *   我们可以通过实现xxxAware 接口，该接口中的方法会通过在创建bean时来进行回调的形式来讲我们的底层组件通过方法来注入给我们
    *   接下来来讲解一些我们常用组件的XXXAware接口
    *
    *   1. ApplicationContextAware 注入我们的IOC容器
    *   2. BeanFactoryAware 注入我们的Bean工厂
    *   3. EnvironmentAware 注入我们的运行环境
    *   4. EmbeddedValueResolverAware 值解析器，比如我们的#{},${}都是由该解析器解析的
    *   5. ImportAware 我们使用Import组件，帮助我们自动导入指定组件
    *   6. BeanNameAware 获取Bean名称，自动指定Bean名称
    *
    *   具体步骤：我们可以通过实现该xxxAware接口，实现接口未实现的方法
    *   通过方法传递给我们的底层组件参数，我们可以将底层组件获取到
    *
    *   底层实现原理是通过postProcessBeforeInitialization 实现的
    *
    * */

}
