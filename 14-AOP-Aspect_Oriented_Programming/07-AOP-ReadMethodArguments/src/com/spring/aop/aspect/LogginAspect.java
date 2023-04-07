package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aop.entity.Account;

@Aspect
@Component
@Order(-1)
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
	
	//@Before("personalPointcutDeclaration()")
	@Before("com.spring.aop.aspect.AspectExpression.forPointcutWithoutGettersAndSetters()")
	public void beforeAddAcountAdvice(JoinPoint theJoinPoint) {
		System.out.println(">>>>>> beforeAddAcountAdvice");
		
		// display the method signtature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method >>> " + methodSignature);
		
		// display methods arguments
		
		
		// get the arguments ant loop through
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArgObject: args) {
			System.out.println(tempArgObject);
			
			if(tempArgObject instanceof Account) {
				Account theAccount = (Account) tempArgObject;
				
				System.out.println("> " + theAccount.getName());
				System.out.println("> " + theAccount.getLevel());
			}
		}
	}
	
}
