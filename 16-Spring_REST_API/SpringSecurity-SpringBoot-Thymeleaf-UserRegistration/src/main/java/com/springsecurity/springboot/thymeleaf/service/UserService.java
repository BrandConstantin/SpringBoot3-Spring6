package com.springsecurity.springboot.thymeleaf.service;

import com.springsecurity.springboot.thymeleaf.entity.User;
import com.springsecurity.springboot.thymeleaf.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
