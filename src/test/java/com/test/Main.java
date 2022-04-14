package com.test;

import cn.mybatis.binding.MapperProxyFactory;
import com.dao.IUserDao;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: mybatis-learning
 * @description:
 * @author: wyn
 * @create: 2022-04-14 21:17
 **/
public class Main {

    @Test
    public void test(){
        Map<String,String> sqlSession = new HashMap<>();
        sqlSession.put("com.dao.IUserDao.getUser","模拟执行getUser的代理逻辑");
        IUserDao iUserDao = new MapperProxyFactory<IUserDao>(IUserDao.class).newInstance(sqlSession);
        System.out.println(iUserDao.getUser());
    }

}
