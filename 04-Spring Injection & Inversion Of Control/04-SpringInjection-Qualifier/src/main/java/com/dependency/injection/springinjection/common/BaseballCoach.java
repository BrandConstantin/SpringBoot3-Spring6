package com.dependency.injection.springinjection.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWork(){ return "Spend 30 min in batting practice"; }
}
