package com.example.devops.with.kubernetes.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RandomStringPrinter {

    private final StringHolder stringHolder;


    public RandomStringPrinter(StringHolder stringHolder) {
        this.stringHolder = stringHolder;
    }

    @Scheduled(fixedRate = 5000)
    public void printRandomString() {
        String timestamp = LocalDateTime.now().toString();
        System.out.println(timestamp + "-" + stringHolder.getRandomString());
    }



}
