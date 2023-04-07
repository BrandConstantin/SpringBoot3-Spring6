package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class ApiAnalyticsAspect {
	//@Before("personalPointcutDeclaration()")
	@Before("com.spring.aop.aspect.AspectExpression.forPointcutWithoutGettersAndSetters()")
	public void performApiAnalytics() {
		System.out.println(">>>>>>>> performApiAnalytics" );
	}
}
