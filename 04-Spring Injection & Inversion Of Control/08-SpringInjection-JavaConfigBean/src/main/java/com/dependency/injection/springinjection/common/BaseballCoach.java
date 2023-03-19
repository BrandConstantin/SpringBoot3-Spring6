package com.dependency.injection.springinjection.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("In constructor class " + getClass().getSimpleName());
    }

    // define the init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("Do my startup stuff");
    }

    // define the destroy method
    @PreDestroy
    public void doMyDestroyStruff(){
        System.out.println("Destroy all my staff!");
    }

    @Override
    public String getDailyWork(){ return "Spend 30 min in batting practice"; }
}
