package com.dependency.injection.springinjection.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWork(){
        return "Practice from CricketCoach";
    }
}
