package com.crm.web.app.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CrmLoggingAspect {
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// settup pointcut declarations
	@Pointcut("execution(* com.crm.web.app.controller.*.*(..))")
	private void forControllerPackage() { }
	@Pointcut("execution(* com.crm.web.app.service.*.*(..))")
	private void forServicePackage() { }
	@Pointcut("execution(* com.crm.web.app.dao.*.*(..))")
	private void forDaoPackage() { }
	
	// combine the poincut
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add advices
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display the method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("Method Before >>> " + theMethod);
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArgs: args) {
			myLogger.info("Arguments >>> " + args);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		// display method we are returnig from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("Method After Returning >>> " + theMethod);
		
		// display the data returned
		myLogger.info("RESULT >>> " + theResult);
	}
}
