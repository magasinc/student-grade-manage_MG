package studentgrades;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student and the grades obtained.
 */
public final class Student {

    /** Minimum valid grade. */
    public static final double MIN_GRADE = 0.0;

    /** Maximum valid grade. */
    public static final double MAX_GRADE = 100.0;

    /** Student identifier. */
    private final String id;

    /** Student full name. */
    private final String name;

    /** Grades obtained by the student. */
    private final List<Double> grades = new ArrayList<>();

    /**
     * Creates a student.
     *
     * @param studentId the student identifier, not empty
     * @param studentName the student name, not empty
     * @throws IllegalArgumentException if the ID or name is empty
     */
    public Student(final String studentId, final String studentName) {
        if (isBlank(studentId)) {
            throw new IllegalArgumentException("The ID cannot be empty.");
        }
        if (isBlank(studentName)) {
            throw new IllegalArgumentException("The name cannot be empty.");
        }
        this.id = studentId.trim();
        this.name = studentName.trim();
    }

    /**
     * Adds a grade to the student.
     *
     * @param grade a number between 0 and 100
     * @throws IllegalArgumentException if the grade is out of range
     */
    public void addGrade(final double grade) {
        if (Double.isNaN(grade) || grade < MIN_GRADE || grade > MAX_GRADE) {
            throw new IllegalArgumentException(
                "Invalid grade " + grade + ": it must be between "
                + MIN_GRADE + " and " + MAX_GRADE + ".");
        }
        grades.add(grade);
    }

    /**
     * Gets the student identifier.
     *
     * @return the identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the student name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets how many grades the student has.
     *
     * @return the number of grades
     */
    public int getGradeCount() {
        return grades.size();
    }

    /**
     * Checks whether a text is null or empty.
     *
     * @param text the text to check
     * @return true if the text is null or has only spaces
     */
    private static boolean isBlank(final String text) {
        return text == null || text.trim().isEmpty();
    }
}
