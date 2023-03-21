package com.ishijie;

import org.example.config.SpringConfigOfAutoWired;
import org.example.dao.PersonDao;
import org.example.entity.Boss;
import org.example.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: com.ishijie
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  18:52
 *@Description: TODO
 *@Version: 1.0
 */
public class IOCTest_Autowired {

    private AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigOfAutoWired.class);

    @Test
    public void test01(){
        PersonService bean = applicationContext.getBean(PersonService.class);
        System.out.println(bean);
        System.out.println(bean.getPersonDao().hashCode());

        PersonDao bean1 = (PersonDao) applicationContext.getBean("personDao");
        System.out.println(bean1);
        System.out.println(bean1.hashCode());
    }

    @Test
    public void test02(){
        Boss bean = applicationContext.getBean(Boss.class);
        System.out.println(bean);
        Object car = applicationContext.getBean("car");
        System.out.println(car);
    }

}
