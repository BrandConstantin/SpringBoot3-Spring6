package com.springbootdemo.demospringboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
    @GetMapping("/devtools")
    public String devToolsWorking(){
        return "Dev Tools is working!";
    }
}
