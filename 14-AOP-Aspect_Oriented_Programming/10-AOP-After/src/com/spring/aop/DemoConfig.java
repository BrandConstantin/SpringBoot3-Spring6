package com.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration						// Spring pure java configuration
@EnableAspectJAutoProxy				// Spring AOP proxy support
@ComponentScan("com.spring.aop")	// Component scan for components and aspects
public class DemoConfig {

}
