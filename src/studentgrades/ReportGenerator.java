package studentgrades;

import java.util.Locale;

/**
 * Builds the summary report of a student.
 */
public final class ReportGenerator {

    /** Line used to frame the report. */
    private static final String SEPARATOR = "================================";

    /** Title of the report. */
    private static final String TITLE = " STUDENT SUMMARY REPORT";

    /** Text shown when a flag is true. */
    private static final String YES = "Yes";

    /** Text shown when a flag is false. */
    private static final String NO = "No";

    /** Prevents creating instances of this class. */
    private ReportGenerator() {
    }

    /**
     * Generates the formatted summary report of a student.
     *
     * @param student the student to report
     * @return the report as text
     */
    public static String generate(final Student student) {
        return String.format(Locale.ROOT,
            "%s%n%s%n%s%n"
            + "Student ID   : %s%n"
            + "Student Name : %s%n"
            + "Grades       : %d%n"
            + "Average      : %.2f%n"
            + "Letter Grade : %s%n"
            + "Status       : %s%n"
            + "Honor Roll   : %s%n"
            + "%s",
            SEPARATOR, TITLE, SEPARATOR,
            student.getId(), student.getName(), student.getGradeCount(),
            student.getAverage(), student.getLetterGrade(),
            student.getPassStatus(), yesNo(student.isHonorRoll()),
            SEPARATOR);
    }

    /**
     * Converts a boolean into text.
     *
     * @param value the value to convert
     * @return "Yes" or "No"
     */
    private static String yesNo(final boolean value) {
        if (value) {
            return YES;
        }
        return NO;
    }
}
