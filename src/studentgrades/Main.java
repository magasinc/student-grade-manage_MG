package studentgrades;

/**
 * Entry point of the student grade management system.
 */
public final class Main {

    /** Sample high grade used in the demonstration. */
    private static final double SAMPLE_HIGH_GRADE = 95.0;

    /** Sample low grade used in the demonstration. */
    private static final double SAMPLE_LOW_GRADE = 72.5;

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
            student.addGrade(SAMPLE_HIGH_GRADE);
            student.addGrade(SAMPLE_LOW_GRADE);
            System.out.println("Grades: " + student.getGradeCount());
            student.addGrade(INVALID_GRADE);
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}
