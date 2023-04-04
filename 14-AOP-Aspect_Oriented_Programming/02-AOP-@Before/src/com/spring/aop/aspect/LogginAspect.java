package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	// add advice for loggin
	// start with @Before advice
	
	@Before("execution(public void addAccount())")
	public void beforeAddAcountAdvice() {
		System.out.println(">>>>>> @Before advice on addAcount()");
	}
}
