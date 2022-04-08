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
        TriggerTask triggerTask = null;
        Task task = new Task(triggerTask,scheduledTaskRegistrar);
        triggerTask = new TriggerTask(task, new MyTrigger());

        scheduledTaskRegistrar.addTriggerTask(triggerTask);

    }

    public static class Task implements Runnable{

        private TriggerTask triggerTask;

        private ScheduledTaskRegistrar scheduledTaskRegistrar;

        public Task(TriggerTask triggerTask,ScheduledTaskRegistrar scheduledTaskRegistrar){
            this.triggerTask = triggerTask;
            this.scheduledTaskRegistrar = scheduledTaskRegistrar;
        }

        @Override
        public void run() {
            System.out.println("hello world!");
            //scheduledTaskRegistrar.lisgetTriggerTaskList().remove(triggerTask);
        }
    }

    public static class MyTrigger implements Trigger{

        @Override
        public Date nextExecutionTime(TriggerContext triggerContext) {
            System.out.println("lastActualExecutionTime:        " + triggerContext.lastActualExecutionTime());
            System.out.println("lastScheduledExecutionTime:        " + triggerContext.lastScheduledExecutionTime());
            System.out.println("lastCompletionTime:        " + triggerContext.lastCompletionTime());
            try {
                if(triggerContext.lastCompletionTime()==null&&triggerContext.lastScheduledExecutionTime()==null&&triggerContext.lastActualExecutionTime()==null){
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-04-08 18:4:00");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
