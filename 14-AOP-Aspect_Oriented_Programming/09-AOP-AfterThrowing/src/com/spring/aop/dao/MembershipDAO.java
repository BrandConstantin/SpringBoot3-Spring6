package com.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println("Add acount: " + getClass());
	}
	
	public void goToSleep() {
		System.out.println("I'm going to sleep!");
	}
}
