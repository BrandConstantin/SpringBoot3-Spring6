package com.spring.aop.dao;

import org.springframework.stereotype.Component;

import com.spring.aop.entity.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount, boolean vip) {
		System.out.println("Add acount: " + getClass());
	}
	
	public boolean doWork() {
		System.out.println("Do work!");
		return true;
	}
}
 