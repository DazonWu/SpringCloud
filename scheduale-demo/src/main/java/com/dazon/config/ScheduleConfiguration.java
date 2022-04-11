package com.dazon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class ScheduleConfiguration implements SchedulingConfigurer {





    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        TriggerTask triggerTask = new TriggerTask(()-> {
            Date date = new Date();
            System.out.println(date);
            System.out.println("hello world!"+ date);
        }, new MyTrigger());

        scheduledTaskRegistrar.addTriggerTask(triggerTask);

    }



    public static class MyTrigger implements Trigger{

        @Override
        public Date nextExecutionTime(TriggerContext triggerContext) {
            System.out.println("lastActualExecutionTime:        " + triggerContext.lastActualExecutionTime());
            System.out.println("lastScheduledExecutionTime:        " + triggerContext.lastScheduledExecutionTime());
            System.out.println("lastCompletionTime:        " + triggerContext.lastCompletionTime());
            try {
                if(triggerContext.lastCompletionTime()==null&&triggerContext.lastScheduledExecutionTime()==null&&triggerContext.lastActualExecutionTime()==null){
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-04-08 23:41:24");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
