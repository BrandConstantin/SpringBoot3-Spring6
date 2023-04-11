package com.springsecurity.springboot.thymeleaf.dao;

import com.springsecurity.springboot.thymeleaf.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
}
