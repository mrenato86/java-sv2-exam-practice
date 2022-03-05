package potpotvizsga.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ExamLearnings {

    private final Map<String, Integer> learnings = new HashMap<>();

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            br.lines()
                    .forEach(this::updateLearnings);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file.", ioe);
        }
    }

    private void updateLearnings(String csvLine) {
        String[] parts = csvLine.split(";");
//        double hours = Arrays.stream(parts)
//                .skip(1)
//                .map(line -> line.replace(',', '.'))
//                .mapToDouble(Double::parseDouble)
//                .sum();
        double hours = IntStream.range(1, parts.length)
                .mapToDouble(i -> Double.parseDouble(parts[i].replace(',', '.')))
                .sum();
        learnings.put(parts[0], (int) (hours * 60));
    }

    public Map<String, Integer> getLearnings() {
        return Map.copyOf(learnings);
    }

    public double getAverageLearningInMinutes() {
        return learnings.values().stream()
                .mapToInt(v -> v)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("There are no learning times."));
    }

}
