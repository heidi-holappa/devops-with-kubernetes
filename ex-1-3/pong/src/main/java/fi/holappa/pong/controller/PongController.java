package fi.holappa.pong.controller;

import fi.holappa.pong.metric.PongCounter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

@RestController
public class PongController {

    private static final String PVC_DIR = "/shared";

    private static final String PONG_FILE = "pong.txt";

    private final PongCounter pongCounter;

    public PongController() {
        this.pongCounter = new PongCounter();
    }


    @GetMapping(value = "/pingpong", produces = "text/html")
    public String ping() {

        pongCounter.increment();

        try {
            writePongCounterToFile();
        } catch (RuntimeException | IOException e) {
            return "ERROR: PVC not mounted. Well, anyways, here's " + pongCounter.toString();
        }

        return pongCounter.toString();

    }

    public void writePongCounterToFile() throws RuntimeException, IOException {

        Path pvcDirectory = Path.of(PVC_DIR);
        Path pongFile = pvcDirectory.resolve(PONG_FILE);

        if (!Files.exists(pvcDirectory)) {
            throw new RuntimeException("PVC not mounted");
        }

        Files.writeString(
                pongFile,
                pongCounter.toString(),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );


    }
}
