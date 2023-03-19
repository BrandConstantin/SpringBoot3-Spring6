package com.dependency.injection.springinjection.common;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In the swim constructor");
    }

    @Override
    public String getDailyWork() {
        return "Swim 1000 meters";
    }
}
