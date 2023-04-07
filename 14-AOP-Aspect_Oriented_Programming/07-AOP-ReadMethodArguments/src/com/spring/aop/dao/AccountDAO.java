package com.spring.aop.dao;

import org.springframework.stereotype.Component;

import com.spring.aop.entity.Account;

@Component
public class AccountDAO {
	private String serviceName;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vip) {
		System.out.println("Add acount: " + getClass());
	}
	
	public boolean doWork() {
		System.out.println("Do work!");
		return true;
	}

	/////////////////////////////////
	
	public String getServiceName() {
		System.out.println("getServiceName");
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		System.out.println("setServiceName");
		this.serviceName = serviceName;
	}

	public String getServiceCode() {
		System.out.println("getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("setServiceCode");
		this.serviceCode = serviceCode;
	}
		
}
 