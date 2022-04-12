package com.dazon.listener;

import cn.hutool.core.date.DateUtil;
import com.dazon.MyJob;
import lombok.SneakyThrows;
import org.apache.commons.lang.time.DateUtils;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyListener implements ApplicationListener<ApplicationStartedEvent> {
    @Autowired
    private Scheduler scheduler;
    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
       // Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-04-11 19:09:30");
        Date date = new Date();
        for (int i = 0; i < 10; i++) {
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


    }
}
