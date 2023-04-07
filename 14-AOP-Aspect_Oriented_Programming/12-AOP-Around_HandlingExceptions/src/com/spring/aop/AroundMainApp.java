package com.spring.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.aop.service.TrafficService;

public class AroundMainApp {
	private static Logger myLogger = Logger.getLogger(AroundMainApp.class.getName());
	
	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficService theTrafficService = context.getBean("trafficService", TrafficService.class);
		
		String data = theTrafficService.getTraffic();
		myLogger.info(">>>>>> Trafic: " + data);
		
		// close the context
		context.close();
	}		

}
