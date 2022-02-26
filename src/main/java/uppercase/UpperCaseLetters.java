package uppercase;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UpperCaseLetters {

    public int getNumberOfUpperCase(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            return (int) br.lines()
                    .flatMapToInt(String::chars)
                    .filter(i -> Character.isUpperCase((char) i))
                    .count();
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }
}
