package com.dependency.injection.springinjection.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("In constructor class " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWork(){
        return "Practice backhand volley";
    }
}
