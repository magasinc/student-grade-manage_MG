/**
 * Entry point of the student grade management system.
 */
public final class Main {

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
            student.addGrade(95.0);
            student.addGrade(72.5);
            System.out.println("Grades: " + student.getGradeCount());
            student.addGrade(150.0);
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}