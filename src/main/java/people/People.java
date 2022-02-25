package people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public int getNumberOfMales(String path) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            return (int) br.lines()
                    .skip(1)
                    .filter(line -> line.contains(",Male,"))
                    .count();
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }
}
