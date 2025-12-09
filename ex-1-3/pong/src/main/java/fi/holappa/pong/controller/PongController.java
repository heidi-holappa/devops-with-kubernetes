package fi.holappa.pong.controller;

import fi.holappa.pong.metric.PongMetric;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongController {

    private final PongMetric pongMetric;

    public PongController() {
        this.pongMetric = new PongMetric();
    }


    @GetMapping(value = "/pingpong", produces = "text/html")
    public String ping() {
        pongMetric.increment();

        return pongMetric.toString();
    }
}
