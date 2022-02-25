package countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DaVinciCode {

    private static final List<Character> CODES = List.of('0', '1', 'x');

    public int encode(String file, char c) {
        if (!CODES.contains(c)) {
            throw new IllegalArgumentException("Invalid character!");
        }
        try (BufferedReader br = Files.newBufferedReader(Path.of(file))) {
            return (int) br.lines()
                    .flatMapToInt(String::chars)
                    .filter(ch -> c == ((char) ch))
                    .count();
        } catch (IOException ioe) {
            throw new IllegalStateException("Error reading file!", ioe);
        }
    }

}
