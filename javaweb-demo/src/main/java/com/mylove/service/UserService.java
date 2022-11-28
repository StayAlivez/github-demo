package com.mylove.service;

import com.mylove.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserService {
    /**
     * 添加用户
     * @param user 用户实体
     */
    void add(User user);

    /**
     * 根据用户名查询 用户名是否存在
     * @param username
     * @return
     */
    User selectUser(String username);
}
