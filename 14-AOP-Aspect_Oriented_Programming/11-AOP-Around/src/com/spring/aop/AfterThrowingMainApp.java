package com.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.dao.AccountDAO;
import com.spring.aop.dao.MembershipDAO;
import com.spring.aop.entity.Account;

public class AfterThrowingMainApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = null;
		try {
			// add a boolean flag to simulate exception
			Boolean tripWire = true; 
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception e) {
			System.out.println("Exception >>>>>> " + e);
		}
		
		System.out.println("AfterThrowingMainApp "  + theAccounts);
		
		// close the context
		context.close();
	}		

}
