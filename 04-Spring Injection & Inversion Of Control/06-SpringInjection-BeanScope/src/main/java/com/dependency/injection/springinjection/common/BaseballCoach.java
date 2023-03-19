package com.dependency.injection.springinjection.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("In constructor class " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWork(){ return "Spend 30 min in batting practice"; }
}
