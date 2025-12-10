package fi.holappa.log.reader.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class LogController {


    @GetMapping(value = "/", produces = "text/html")
    public String getLastLogEntry() throws IOException {

        try {
            String path = "/shared/log.txt";
            List<String> lines = Files.readAllLines(Paths.get(path));

            if (lines.size() != 1) {
                throw new RuntimeException("The log file should have exactly one line");
            }

                return lines.getFirst();

        } catch (IOException e) {
            throw new RuntimeException("Unable to read file", e);
        }
    }
}
