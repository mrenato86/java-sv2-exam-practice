package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public int sumIgnoreComments(String file) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(file))) {
            return br.lines()
                    .filter(line -> !line.startsWith("//"))
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }
}
