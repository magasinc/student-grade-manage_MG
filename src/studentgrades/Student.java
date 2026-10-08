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

    /** Minimum average for letter A. */
    public static final double MIN_A = 90.0;

    /** Minimum average for letter B. */
    public static final double MIN_B = 80.0;

    /** Minimum average for letter C. */
    public static final double MIN_C = 70.0;

    /** Minimum average for letter D. */
    public static final double MIN_D = 60.0;

    /** Minimum average to pass. */
    public static final double MIN_PASSING_AVERAGE = MIN_D;

    /** Minimum average to be on the honor roll. */
    public static final double MIN_HONOR_AVERAGE = MIN_A;

    /** Text shown for a passing student. */
    public static final String STATUS_PASSED = "Passed";

    /** Text shown for a failing student. */
    public static final String STATUS_FAILED = "Failed";

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
     * Removes the first grade that matches a value.
     *
     * @param grade the grade value to remove
     * @throws IllegalArgumentException if the grade does not exist
     */
    public void removeGradeByValue(final double grade) {
        if (!grades.remove(Double.valueOf(grade))) {
            throw new IllegalArgumentException(
                "Grade " + grade + " not found.");
        }
    }

    /**
     * Removes the grade at a position, where 1 is the first grade.
     *
     * @param position the position of the grade, starting at 1
     * @return the grade that was removed
     * @throws IllegalArgumentException if the position is out of range
     */
    public double removeGradeAt(final int position) {
        if (position < 1 || position > grades.size()) {
            throw new IllegalArgumentException(
                "Position " + position + " is out of range. The student has "
                + grades.size() + " grade(s).");
        }
        return grades.remove(position - 1);
    }


    /**
     * Calculates the average of all grades.
     *
     * @return the average, or 0.0 if the student has no grades
     */
    public double getAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (final double grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }

    /**
     * Converts the average into a letter grade.
     *
     * @return A, B, C, D or F
     */
    public char getLetterGrade() {
        final double average = getAverage();
        if (average >= MIN_A) {
            return 'A';
        }
        if (average >= MIN_B) {
            return 'B';
        }
        if (average >= MIN_C) {
            return 'C';
        }
        if (average >= MIN_D) {
            return 'D';
        }
        return 'F';
    }

    /**
     * Checks whether the student passed.
     *
     * @return true if the average is 60 or higher
     */
    public boolean isPassed() {
        return getAverage() >= MIN_PASSING_AVERAGE;
    }

    /**
     * Gets the pass or fail status as text.
     *
     * @return "Passed" or "Failed"
     */
    public String getPassStatus() {
        if (isPassed()) {
            return STATUS_PASSED;
        }
        return STATUS_FAILED;
    }

    /**
     * Checks whether the student is on the honor roll.
     *
     * @return true if the average is 90 or higher
     */
    public boolean isHonorRoll() {
        return getAverage() >= MIN_HONOR_AVERAGE;
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
