package studentgrades;

import java.util.Locale;

/**
 * Entry point of the student grade management system.
 */
public final class Main {

    /** Sample grades used in the demonstration. */
    private static final double[] DEMO_GRADES = {95.0, 72.5, 88.0};

    /** Out of range grade used to show error handling. */
    private static final double INVALID_GRADE = 150.0;

    /** Prevents creating instances of this class. */
    private Main() {
    }

    /**
     * Runs a small demonstration.
     *
     * @param args command line arguments, not used
     */
    public static void main(final String[] args) {
        try {
            Student student = new Student("A001", "Ana Perez");
            for (double grade : DEMO_GRADES) {
                student.addGrade(grade);
            }
            System.out.println("Grades: " + student.getGradeCount());
            System.out.println(String.format(Locale.ROOT,
                "Average: %.2f", student.getAverage()));
            System.out.println("Letter grade: " + student.getLetterGrade());
            System.out.println("Status: " + student.getPassStatus());
            System.out.println("Honor roll: " + student.isHonorRoll());
            student.addGrade(INVALID_GRADE);
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}
