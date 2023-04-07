package com.spring.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficService {
	public String getTraffic() {
		// simulate a dalay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// return a trafic
		return "Heavy trafic on the red!";
	}

	public String getTraffic(boolean tripWire) {
		// simulate an exception
		if(tripWire) {
			throw new RuntimeException("To many traffic in the red!");
		}
		
		return getTraffic();
	}
}
