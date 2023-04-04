package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.dao.AccountDAO;

public class MainApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();
		
		// call business method again
		System.out.println("Do it again!");
		theAccountDAO.addAccount();
		
		// close the context
		context.close();
	}		

}
