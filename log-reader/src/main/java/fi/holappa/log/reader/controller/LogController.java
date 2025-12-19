package fi.holappa.log.reader.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class LogController {

    private static final Path PONG_FILE_PATH = Path.of("/shared/pong.txt");
    private static final Path LOG_FILE_PATH = Path.of("/shared/log.txt");

    @GetMapping(value = "/", produces = "text/html")
    public String getLastLogEntry() throws RuntimeException {
        return getEntryForPath(LOG_FILE_PATH) + "\n" + getEntryForPath(PONG_FILE_PATH);
    }

    public String getEntryForPath(Path path) throws RuntimeException {

        try {

            String logOutput = "";

            if (Files.exists(path)) {

                List<String> lines = Files.readAllLines(path);

                if (lines.size() != 1) {
                    throw new RuntimeException("The log file should have exactly one line");
                }
                logOutput =  lines.getFirst();

            } else {
                logOutput = "File " + path.toString() + " does not yet exist";
            }

            return logOutput;

        } catch (IOException e) {
            throw new RuntimeException("Unable to read file", e);
        }
    }
}
