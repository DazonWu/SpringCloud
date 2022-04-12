package com.dazon.controller;

import com.dazon.MyJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
public class TestController {

    private AtomicInteger num = new AtomicInteger(10000);


    @Autowired
    private Scheduler scheduler;

    @GetMapping
    public String test() throws ParseException, SchedulerException {
        Date date = new Date();
        for (int i = 20; i < 30; i++) {
            if(i>25){
                scheduler.deleteJob(new JobKey(i-1+"","key"));
            }

            SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
            simpleTrigger.setStartTime(DateUtils.addMinutes(date,1));
            simpleTrigger.setRepeatCount(1);
            //simpleTrigger.setJobKey(new JobKey(i+"","key"));
            //30s重试
            simpleTrigger.setRepeatInterval(30000);
            simpleTrigger.setEndTime(DateUtils.addMinutes(date,2));
            simpleTrigger.setName(i+"");
            simpleTrigger.setJobName(i+"");
            simpleTrigger.setJobGroup("key");


            JobDetailImpl jobDetail = new JobDetailImpl();
            jobDetail.setKey(new JobKey(i+"","key"));
            jobDetail.setDescription("test");
            jobDetail.setJobClass(MyJob.class);
            jobDetail.setDurability(false);
            //jobDetail.setGroup();
            jobDetail.setJobDataMap(null);
            jobDetail.setName(i+"");
            jobDetail.setRequestsRecovery(true);
            jobDetail.setDurability(true);
            try {
                scheduler.addJob(jobDetail,true);

                scheduler.start();
                scheduler.scheduleJob(simpleTrigger);


                //scheduler.scheduleJob(jobDetail, simpleTrigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }


        /*Date date = new Date();
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setKey(new JobKey(num.incrementAndGet()+""));
        jobDetail.setDescription("test");
        jobDetail.setJobClass(MyJob.class);
        jobDetail.setDurability(true);
        //jobDetail.setGroup();
        jobDetail.setJobDataMap(null);
        jobDetail.setName("12345");
        jobDetail.setRequestsRecovery(true);
        scheduler.addJob(jobDetail,true);

        SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
        simpleTrigger.setStartTime(DateUtils.addSeconds(date,20));
        simpleTrigger.setRepeatCount(1);
        simpleTrigger.setName("12345");
        //30s重试
        simpleTrigger.setRepeatInterval(30000);
        simpleTrigger.setEndTime(DateUtils.addMinutes(date,1));

        scheduler.scheduleJob(jobDetail, simpleTrigger);*/
        return "success";
    }
}
