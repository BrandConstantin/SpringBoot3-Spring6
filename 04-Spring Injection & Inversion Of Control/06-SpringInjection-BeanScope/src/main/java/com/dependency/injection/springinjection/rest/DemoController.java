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
    private Coach anotherCoach;

    // create the constructor injection
    @Autowired
    public DemoController(
            @Qualifier("baseballCoach") Coach theCoach,
            @Qualifier("baseballCoach") Coach theAnotherCoach){
        System.out.println("In the controller " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWork();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: " + (myCoach == anotherCoach);
    }
}
