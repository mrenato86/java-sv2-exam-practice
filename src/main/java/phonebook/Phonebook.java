package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException("All parameters must be provided!");
        }
//        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(output))) {
//            for (Map.Entry<String, String> entry : contacts.entrySet()) {
//                writer.write(entry.getKey() + ": " + entry.getValue());
//                writer.newLine();
//            }
//        } catch (IOException ioe) {
//            throw new IllegalStateException("File writing error!", ioe);
//        }
        List<String> lines = contacts.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .toList();
        writeToFile(Path.of(output), lines);
    }

    private void writeToFile(Path path, List<String> data) {
        try {
            Files.write(path, data);
        } catch (IOException ioe) {
            throw new IllegalStateException("File writing error!", ioe);
        }
    }
}
