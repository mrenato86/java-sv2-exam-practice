package potvizsga.students;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private String className;
    private final List<Integer> grades = new ArrayList<>();

    public Student(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public void addGrade(int grade) {
        if (grade < 0 || grade > 5) {
            throw new IllegalArgumentException("Invalid grade: " + grade);
        }
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public List<Integer> getGrades() {
        return List.copyOf(grades);
    }
}
