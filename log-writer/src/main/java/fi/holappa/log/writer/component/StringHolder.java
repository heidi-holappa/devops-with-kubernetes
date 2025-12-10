package fi.holappa.log.writer.component;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@EnableScheduling
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
