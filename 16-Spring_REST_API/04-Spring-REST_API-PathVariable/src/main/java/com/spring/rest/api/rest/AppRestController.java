package com.spring.rest.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AppRestController {
	@GetMapping("/hello")
	public String sayHello(){
		return "hello world";
	}
}
