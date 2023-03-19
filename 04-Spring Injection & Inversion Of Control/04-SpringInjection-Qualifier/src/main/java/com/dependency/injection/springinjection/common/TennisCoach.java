package com.dependency.injection.springinjection.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWork(){
        return "Practice backhand volley";
    }
}
