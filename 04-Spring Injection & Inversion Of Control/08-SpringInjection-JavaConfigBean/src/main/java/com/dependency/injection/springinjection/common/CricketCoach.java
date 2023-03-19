package com.dependency.injection.springinjection.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("In constructor class " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWork(){
        return "Practice from CricketCoach";
    }
}
