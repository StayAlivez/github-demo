package com.mylove.mapper;

import com.mylove.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import javax.servlet.annotation.WebServlet;

public interface UserMapper {

    /**
     * 添加用户
     * @param user 用户实体
     */
    @Insert("insert into tb_user(username, password, email) values (#{username},#{password},#{email})")
    void add(User user);

    /**
     * 根据用户名查询 用户名是否存在
     * @param username
     * @return
     */
    @Select("select * from tb_user where username=#{username}")
    User selectUser(String username);

    
}
