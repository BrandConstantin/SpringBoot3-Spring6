package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectExpression {
	// pointcut declaration
	@Pointcut("execution(* com.spring.aop.dao.*.*(..))")
	public void personalPointcutDeclaration() {}
	
	// combining pointcuts
	// create pointcuts for getters and setters
	@Pointcut("execution(* com.spring.aop.dao.*.get*(..))")
	public void getterPoint() {}
	@Pointcut("execution(* com.spring.aop.dao.*.set*(..))")
	public void setterPoint() {}
	
	// create poincuts incluing the package, exclude getters/setters
	@Pointcut("personalPointcutDeclaration() && !(getterPoint() || setterPoint())")
	public void forPointcutWithoutGettersAndSetters() {}
}
