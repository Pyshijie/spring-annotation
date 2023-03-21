package org.example.controller;

import org.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.controller
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  08:50
 *@Description: TODO
 *@Version: 1.0
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

}
