package com.example.raihan.foodforall;

public class ActivityFactorySingleTon {
    public static ActivityFactory activityFactory;

    public static ActivityFactory getActivityFactory() {
        if(activityFactory==null){
            activityFactory = new ActivityFactory();
        }
        return activityFactory;
    }
}
