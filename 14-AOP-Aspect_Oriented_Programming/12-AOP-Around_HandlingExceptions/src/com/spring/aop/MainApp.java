package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.dao.AccountDAO;
import com.spring.aop.dao.MembershipDAO;
import com.spring.aop.entity.Account;

public class MainApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		Account myAccount = new Account();
		myAccount.setName("Service-FFD845");
		myAccount.setLevel("3");
		
		// call the business method
		theAccountDAO.addAccount(myAccount, true);
		
		// call business method again
		System.out.println("Do it again!");
		theAccountDAO.addAccount(myAccount, false);
		theAccountDAO.doWork();
		
		// call the getter/setter methods from accountdao
		theAccountDAO.setServiceName("Service-OCN012");
		theAccountDAO.setServiceCode("ocn012");
		theAccountDAO.getServiceName();
		theAccountDAO.getServiceCode();
		
		// call bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();
	}		

}
