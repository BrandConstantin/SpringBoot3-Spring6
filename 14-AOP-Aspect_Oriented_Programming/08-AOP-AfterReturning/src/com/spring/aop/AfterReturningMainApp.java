package com.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.dao.AccountDAO;
import com.spring.aop.dao.MembershipDAO;
import com.spring.aop.entity.Account;

public class AfterReturningMainApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("AfterReturnignMainApp "  + theAccounts);
		
		// close the context
		context.close();
	}		

}
