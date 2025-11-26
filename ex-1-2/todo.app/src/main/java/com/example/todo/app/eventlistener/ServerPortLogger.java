package com.example.todo.app.eventlistener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.server.context.WebServerApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class ServerPortLogger {

    private final WebServerApplicationContext context;

    public ServerPortLogger(WebServerApplicationContext context) {
        this.context = context;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void logPort() throws NullPointerException {
        int port = context.getWebServer().getPort();
        System.out.println("Server port: " + port);
        System.out.println("Using updated image");
    }
}