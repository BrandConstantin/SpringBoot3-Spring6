package com.springsecurity.springboot.thymeleaf.dao;

import com.springsecurity.springboot.thymeleaf.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
