package studentgrades;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point of the student grade management system.
 */
public final class Main {

    /** Grades of the first demo student. */
    private static final double[] ANA_GRADES = {95.0, 92.0, 98.5};

    /** Grades of the second demo student. */
    private static final double[] LUIS_GRADES = {72.5, 65.0, 80.0};

    /** Grades of the third demo student. */
    private static final double[] MARIA_GRADES = {45.0, 58.5};

    /** Empty list of grades. */
    private static final double[] NO_GRADES = {};

    /** Invalid grade texts used to show error handling. */
    private static final String[] BAD_INPUTS = {"Ninety", "", "101", "-5"};

    /** Prevents creating instances of this class. */
    private Main() {
    }

    /**
     * Runs a demonstration of the whole system.
     *
     * @param args command line arguments, not used
     */
    public static void main(final String[] args) {
        List<Student> students = new ArrayList<>();
        registerStudent(students, "A001", "Ana Perez", ANA_GRADES);
        registerStudent(students, "A002", "Luis Mora", LUIS_GRADES);
        registerStudent(students, "A003", "Maria Lopez", MARIA_GRADES);
        registerStudent(students, " ", "Student Without Id", NO_GRADES);
        registerStudent(students, "A004", "", NO_GRADES);

        tryInvalidGrades(students.get(0));
        printReports(students);
    }

    /**
     * Creates a student with grades and stores it, or shows the error.
     *
     * @param students the list where the student is stored
     * @param id the student identifier
     * @param name the student name
     * @param grades the grades to add
     */
    private static void registerStudent(final List<Student> students,
                                        final String id, final String name,
                                        final double[] grades) {
        try {
            Student student = new Student(id, name);
            for (double grade : grades) {
                student.addGrade(grade);
            }
            students.add(student);
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /**
     * Tries to add invalid grades to a student and shows each error.
     *
     * @param student the student that receives the grades
     */
    private static void tryInvalidGrades(final Student student) {
        for (String text : BAD_INPUTS) {
            try {
                student.addGradeFromText(text);
            } catch (IllegalArgumentException error) {
                System.out.println("Error: " + error.getMessage());
            }
        }
    }

    /**
     * Prints the summary report of every student.
     *
     * @param students the students to report
     */
    private static void printReports(final List<Student> students) {
        for (Student student : students) {
            System.out.println(ReportGenerator.generate(student));
            System.out.println();
        }
    }
}
