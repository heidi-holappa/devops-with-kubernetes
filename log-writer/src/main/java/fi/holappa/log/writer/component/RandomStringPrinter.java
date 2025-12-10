package fi.holappa.log.writer.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

@Component
public class RandomStringPrinter {

    private final StringHolder stringHolder;


    public RandomStringPrinter(StringHolder stringHolder) {
        this.stringHolder = stringHolder;
    }

    @Scheduled(fixedRate = 5000)
    public void printRandomString() throws IOException  {
        String timestamp = LocalDateTime.now().toString();

        Path dir = Path.of("/shared");
        Path file = dir.resolve("log.txt");

        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }

        String logEntry = timestamp + "::" + stringHolder.getRandomString();

        Files.writeString(
                file,
                logEntry,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }



}
