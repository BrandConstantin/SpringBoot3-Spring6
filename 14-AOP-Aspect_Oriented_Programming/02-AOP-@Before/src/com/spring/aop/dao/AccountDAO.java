package com.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println("Add acount: " + getClass());
	}
}
 