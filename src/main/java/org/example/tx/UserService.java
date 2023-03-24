package org.example.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("all")
/**
 *@BelongsProject: spring-annotation
 *@BelongsPackage: org.example.tx
 *@Author: yinxiaochao
 *@CreateTime: 2023-03-24  11:12
 *@Description: TODO
 *@Version: 1.0
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Transactional //该方法添加事务
    public void insert(){
        userDao.insert();
        System.out.println("插入了一条数据");
        int i = 10 / 0; //模拟异常，事务回滚
    }

}
