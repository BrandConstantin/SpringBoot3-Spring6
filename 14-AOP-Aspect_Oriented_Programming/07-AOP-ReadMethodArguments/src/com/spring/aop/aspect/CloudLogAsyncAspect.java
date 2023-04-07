package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(13)
public class CloudLogAsyncAspect {
	@Before("com.spring.aop.aspect.AspectExpression.forPointcutWithoutGettersAndSetters()")
	public void logToCloudAsync() {
		System.out.println(">>>>>>>> logToCloudAsync" );
	}
}
