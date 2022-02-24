package workhours;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
        return readLinesFromFile(Path.of(file)).stream()
                .map(WorkHour::new)
                .min(Comparator.comparingInt(w -> w.hours))
                .orElseThrow(() -> new IllegalArgumentException("Empty file!"))
                .toString();
    }

    private List<String> readLinesFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private static class WorkHour {
        private final String name;
        private final int hours;
        private final LocalDate date;

        private WorkHour(String line) {
            String[] parts = line.split(",");
            this.name = parts[0];
            this.hours = Integer.parseInt(parts[1]);
            this.date = LocalDate.parse(parts[2]);
        }

        @Override
        public String toString() {
            return name + ": " + date;
        }
    }
}
