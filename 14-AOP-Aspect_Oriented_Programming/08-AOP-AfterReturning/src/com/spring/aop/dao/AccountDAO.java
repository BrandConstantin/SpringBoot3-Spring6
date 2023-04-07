package com.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aop.entity.Account;

@Component
public class AccountDAO {
	private String serviceName;
	private String serviceCode;
	
	// new method for after returning
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		
		// crate accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Naru", "Platinum");
		Account temp3 = new Account("Larissa", "Gold");
		
		// add to the list
		myAccounts.add(temp3);
		myAccounts.add(temp2);
		myAccounts.add(temp1);
		
		return myAccounts;  
	}
	
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
 