package com.spring.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.aop.service.TrafficService;

public class AroundHandlingExceptionMainApp {
	private static Logger myLogger = Logger.getLogger(AroundHandlingExceptionMainApp.class.getName());
	
	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficService theTrafficService = context.getBean("trafficService", TrafficService.class);
		
		// simulate an exception
		boolean tripWire = true;
		String data = theTrafficService.getTraffic(tripWire);
		myLogger.info(">>>>>> Trafic: " + data);
		
		// close the context
		context.close();
	}		

}
