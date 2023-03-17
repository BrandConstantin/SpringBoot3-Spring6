package com.springbootdemo.demospringboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // inject custom properties
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
    @GetMapping("/devtools")
    public String devToolsWorking(){
        return "Dev Tools is working!";
    }

    @GetMapping("/home")
    public String home(){
        return "This is home working!";
    }

    @GetMapping("/teamInfo")
    public String getTeamName(){
        return "Team info: " + coachName + " - " + teamName;
    }

}
