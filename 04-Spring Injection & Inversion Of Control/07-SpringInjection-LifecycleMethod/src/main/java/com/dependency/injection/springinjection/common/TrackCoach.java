package com.dependency.injection.springinjection.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    public TrackCoach(){
        System.out.println("In constructor class " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWork(){ return "Run hard 5k"; }
}
