package com.dazon;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.ee.jmx.jboss.QuartzService;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyJob implements Job {

    private final AtomicInteger num = new AtomicInteger(0);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        log.info("hello test__________"+num.incrementAndGet());


    }
}
