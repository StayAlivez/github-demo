package com.mylove.service.impl;

import com.mylove.mapper.UserMapper;
import com.mylove.pojo.User;
import com.mylove.service.UserService;
import com.mylove.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {
    // 1.创建 SqlSessionFactory 工厂 对象
    SqlSessionFactory factory= SqlSessionFactoryUtils.getSqlSessionFactory();
    public void add(User user) {
        // 2.获取 SqlSession  对象
        SqlSession sqlSession = factory.openSession();
        // 3.获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4.调用方法
        mapper.add(user);
        // 5.提交事物
        sqlSession.commit();
        // 6.释放资源
        sqlSession.close();
    }

    @Override
    public User selectUser(String username) {
        // 2.获取 SqlSession  对象
        SqlSession sqlSession = factory.openSession();
        // 3.获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4.调用方法
        User user = mapper.selectUser(username);

        // 6.释放资源
        sqlSession.close();
        return user;
    }
}
