import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static Map<String, Status> students;
    public static Scanner reader;

    public static String[] sort(String[] toBeSorted) {
        return toBeSorted;// actual sorting part
    }

    public static void main(String[] args) throws Exception {
        students = new HashMap<>();

        reader = new Scanner(System.in); // Reading from System.in

        while (true) {
            System.out.println("\033[2J");
            listStudents();
            System.out.println(
                    "add a new student: enter A plus the name. mark attendance: enter M plus the ID plus present or absent. make a report: press R");
            String[] line = reader.nextLine().split(" ");
            String decision = line[0].toUpperCase();
            switch (decision) {
                case "A":
                    String name = line[1];
                    students.put(name, Status.UNKNOWN);
                    break;
                case "M":
                    String studentName = line[1];
                    Status currentStatus = Status.valueOf(line[2].toUpperCase());
                    students.put(studentName, currentStatus);
                    System.out.println("Attendance");
                    break;

                case "R":
                    if (students == null) {
                        System.out.println("No students to report. ");
                        return;
                    }
                    FileWriter writer = new FileWriter(new File("report"));
                    writer.append("NAME, STATUS");
                    students.forEach((thisStudentName, status) -> {
                        try {
                            writer.append(thisStudentName + ", " + status + "\n");
                        } catch (Exception e) {
                        }
                    });
                    writer.append("TOTAL: X PRESENT, X ABSENT, X UNKNOWN");
                    writer.close();
                    System.out.println("Report has been generated.");
                    break;
                case "Q":
                    System.out.println("Quit?");
                    if (reader.nextLine() == "Y") {
                        return;
                    }
                    break;
                default:
                    System.out.println("Could not recognize. Valid options are A, M, R, or Q");

            }
        }

    }

    static void listStudents() {

        System.out.println("Current Students: ");
        if (students != null)
            students.forEach((user, status) -> {
                System.out.println(user + " " + status);
            });
        System.out.println("-------------------------");
    }
}
