package studentgrades;

/**
 * Entry point of the student grade management system.
 */
public final class Main {

    /** Sample grades used in the demonstration. */
    private static final double[] DEMO_GRADES = {95.0, 72.5, 88.0};

    /** Grade that exists and will be removed by value. */
    private static final double GRADE_TO_REMOVE = 72.5;

    /** Grade that does not exist, to show error handling. */
    private static final double MISSING_GRADE = 33.0;

    /** Valid position that will be removed. */
    private static final int POSITION_TO_REMOVE = 1;

    /** Position out of range, to show error handling. */
    private static final int INVALID_POSITION = 9;

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
            printSummary(student);
            tryRemoveByValue(student, GRADE_TO_REMOVE);
            tryRemoveByValue(student, MISSING_GRADE);
            tryRemoveAt(student, INVALID_POSITION);
            tryRemoveAt(student, POSITION_TO_REMOVE);
            printSummary(student);
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /**
     * Prints the number of grades and the average.
     *
     * @param student the student to summarize
     */
    private static void printSummary(final Student student) {
        System.out.println("Grades: " + student.getGradeCount());
        System.out.printf(java.util.Locale.ROOT, "Average: %.2f%n",
            student.getAverage());
    }

    /**
     * Removes a grade by value and shows the result.
     *
     * @param student the student
     * @param grade the grade value to remove
     */
    private static void tryRemoveByValue(final Student student,
                                         final double grade) {
        try {
            student.removeGradeByValue(grade);
            System.out.println("Removed grade " + grade + ".");
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /**
     * Removes a grade by position and shows the result.
     *
     * @param student the student
     * @param position the position to remove, starting at 1
     */
    private static void tryRemoveAt(final Student student,
                                    final int position) {
        try {
            double removed = student.removeGradeAt(position);
            System.out.println("Removed grade " + removed
                + " at position " + position + ".");
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}
