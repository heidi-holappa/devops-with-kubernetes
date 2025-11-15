package com.example.devops.with.kubernetes.component;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringHolder {

    private String randomString;

    @PostConstruct
    public void init() {
        this.randomString = UUID.randomUUID().toString();
    }

    public String getRandomString() {
        return this.randomString;
    }
}
