package org.example.service;

import org.example.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.service
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  08:50
 *@Description: TODO
 *@Version: 1.0
 */
@Service
public class PersonService {

    @Autowired
    @Qualifier("personDao2")
    private PersonDao personDao;

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "personDao=" + personDao +
                '}';
    }
}
