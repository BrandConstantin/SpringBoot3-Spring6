package com.dependency.injection.springinjection.rest;

import com.dependency.injection.springinjection.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define the properties field for the dependency
    private Coach myCoach;

    // create the constructor injection
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach){
        System.out.println("In the controller " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWork();
    }

}
