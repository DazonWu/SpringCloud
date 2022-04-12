package com.dazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class App {

    public static void main(String[] args) {
        //CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator("0 4 13 12 4 ? 2022");
        //CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator("0 15 10 12 4 ? *");


        SpringApplication.run(App.class);
    }

}
