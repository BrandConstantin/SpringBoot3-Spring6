package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	// add advice for loggin
	// start with @Before advice
	
	// all the methdos with the same name
	//@Before("execution(public void addAccount())") 
	
	// only the method in this class
	//@Before("execution(public void com.spring.aop.dao.AccountDAO.addAccount())") 
	
	// all the methos that start with add
	//@Before("execution(public void add*())")
	
	// with return type // (* void add*()) // the modifier is optional
	//@Before("execution(void add*())")
	
	// match with a parameter
	//@Before("execution(void add*(com.spring.aop.entity.Account))")	
	
	// more parameter types
	//@Before("execution(void add*(com.spring.aop.entity.Account, ..))")	
	
	// match in the package
	//@Before("execution(* com.spring.aop.dao.*.*(..))")	
	
	// pointcut declaration
	@Pointcut("execution(* com.spring.aop.dao.*.*(..))")
	private void personalPointcutDeclaration() {}
	
	@Before("personalPointcutDeclaration()")
	public void beforeAddAcountAdvice() {
		System.out.println(">>>>>> @Before advice on addAcount()");
	}
	
	@Before("personalPointcutDeclaration()")
	public void performApiAnalytics() {
		System.out.println(">>>>>>>> @Before reuse" );
	}
}
