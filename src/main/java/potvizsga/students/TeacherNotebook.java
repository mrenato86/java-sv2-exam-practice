package potvizsga.students;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherNotebook {

    private static final double FAIL_LIMIT = 2.;

    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            br.lines()
                    .map(this::parseStudent)
                    .forEach(students::add);
        } catch (IOException | NumberFormatException e) {
            throw new IllegalArgumentException("Error during file reading: " + e.getMessage(), e);
        }
    }

    private Student parseStudent(String csvLine) {
        String[] parts = csvLine.split(";");
        Student student = new Student(parts[0], parts[1]);
        Arrays.stream(parts)
                .skip(2)
                .map(Integer::parseInt)
                .forEach(student::addGrade);
        return student;
    }

    public List<String> findFailingStudents() {
        return students.stream()
                .filter(s -> s.getGrades().stream()
                        .mapToInt(g -> g)
                        .average()
                        .orElse(0.) < FAIL_LIMIT)
                .map(Student::getName)
                .collect(Collectors.toList());
    }
}
