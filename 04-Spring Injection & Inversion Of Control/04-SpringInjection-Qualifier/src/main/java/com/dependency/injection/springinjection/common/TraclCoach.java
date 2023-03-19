package com.dependency.injection.springinjection.common;

import org.springframework.stereotype.Component;

@Component
public class TraclCoach implements Coach{
    @Override
    public String getDailyWork(){ return "Run hard 5k"; }
}
