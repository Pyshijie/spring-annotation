package org.example.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;
import java.util.UUID;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.tx
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-24  11:06
 *@Description: TODO
 *@Version: 1.0
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){

        String sql = "INSERT INTO `tb_person` (`name`,`age`) VALUES (?,?)";
        String username = UUID.randomUUID().toString().substring(0, 5);
        int age = new Random().nextInt(30);
        jdbcTemplate.update(sql,username,age);

    }

}
