package org.example.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.dao
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-21  08:50
 *@Description: TODO
 *@Version: 1.0
 */
@Repository
public class PersonDao {

    //@Value("1")
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public PersonDao(String label) {
        this.label = label;
    }

    public PersonDao() {
    }

    @Override
    public String toString() {
        return "PersonDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
