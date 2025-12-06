package com.example.devops.with.kubernetes.controller;

import com.example.devops.with.kubernetes.component.StringHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class LogController {

    private final StringHolder stringHolder;


    public LogController(StringHolder stringHolder) {
        this.stringHolder = stringHolder;
    }

    @GetMapping(value = "/", produces = "text/html")
    public String getMostRecentLogEntry() {
        String timestamp = LocalDateTime.now().toString();

        return timestamp + "-" + stringHolder.getRandomString();
    }
}
