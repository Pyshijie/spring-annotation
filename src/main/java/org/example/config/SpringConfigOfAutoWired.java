package org.example.config;

import org.example.dao.PersonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.config
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  18:52
 *@Description: TODO
 *@Version: 1.0
 */
@Configuration
@ComponentScan(basePackages = {
        /*"org.example.controller","org.example.dao","org.example.service",*/"org.example.entity"
})
public class SpringConfigOfAutoWired {

    /*
    * @AutoWired 完成自动装配功能 --> ioc容器中各个组件之间的依赖属性赋值
    *   1. @AutoWired默认按照类型进行装配，如果bean类型匹配就进行装配
    *   2. 如果有多个相同类型的bean，那么会按照bean的名字进行装配，会与属性名称进行匹配，如果bean的name和属性名称匹配那么就会进行装配
    *   3. 可以通过@Qualifier("personDao2") 指定要装配的bean,这里就会指定装配personDao2的bean
    *   4. 如果没有该类型的bean.但是进行了自动装配，会进行报错，NoSuchBeanException,因此自动装配的bean必须赋初值
    *   5. 如果想要达到，如果有该bean那么就进行装配，如果没有就不进行装配也不报错的效果，那么可以在
    *       @AutoWired 中设置required 为 false,来达到这个效果
    *   6. 可以结合@Primary 注解，让spring在每次装配bean的时候，优先注入@Primary标注的bean，但是使用@Primary
    *       就不要使用@Qualifier了,因为@Qualifier 会指定bean，此时优先注解就失效了.
    *   7. JSR 250 退出了 @Resource 注解：与@AutoWired一致也是可以进行自动装配
    *       但是@Resource 注解不支持@Primary优先级注解，而且也不支持@AutoWired的required=false的设置
    *      JSR 330 推出了 @Inject注解，与@AutoWired一直也是可以进行自动装配
    *       @Inject 在使用前需要导入 javax.inject 依赖
    *       @Inject 支持 @Primary 优先级主机
    *       但是不支持@AutoWired 的required=false的设置
    *   8. @Autowired 是 Spring管理的   @Resource和@Inject 是 java的规范
    *
    *   9. 日常开发推荐使用@AutoWired 和 @Qualifier 结合使用
    *   @Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
    *   @AutoWired 可以标注在构造器,方法,参数,字段上
    *   1. 标注在构造器上，那么会使用该构造器进行初始化，而且构造器中的参数是直接从IOC容器中获取的
    *      如果只有一个有参构造器，那么@AutoWired 可以省略不写，默认也会使用有参构造器进行创建对象
    *   2. 标注在方法上，比如set方法上，那么会在构造器创建对象后，自动调用该方法，该方法的参数也是直接从IOC容器中获取
    *   3. 标注在参数上，那么就表名该参数直接从IOC容器中获取
    *   4. 字段上，正常情况的注入.
    * */

    @Bean
    public PersonDao personDao2(){
        return new PersonDao("2");
    }


}
