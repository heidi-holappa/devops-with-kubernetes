package com.example.todo.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping(value = "/", produces = "text/html")
    public String hello() {
        return "<h1>Hello World!</h>";
    }
}
