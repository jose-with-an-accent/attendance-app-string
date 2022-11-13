package strings;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class App {

    public static Map<String, Status> students;
    public static Scanner reader;
    
    public static String[] sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
        return a;

    } 
	public static void sort(String[] a, int lo, int hi, int d)
	{
		if (hi <= lo) 
		{
			return;
		}
		int lt = lo, gt = hi;
		int v = Utils.charAt(a[lo], d);
		int i = lo + 1;
		while (i <= gt)
	{
		int t = Utils.charAt(a[i], d);
		if (t < v) 
		{
			Utils.exch(a, lt++, i++);
		}
		else if (t > v) 
		{
			Utils.exch(a, i, gt--);
		}
		else i++;
	}
	// a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
		sort(a, lo, lt-1, d);
		if (v >= 0) {
			sort(a, lt, gt, d+1);
		}
		sort(a, gt+1, hi, d);
	}
	// end algorithm, begin small app that uses the alg.
    public static void main(String[] args) throws Exception {
        attendance_main();
    }

    public static void attendance_main() throws Exception {
        students = new HashMap<>();

        reader = new Scanner(System.in); // Reading from System.in

        while (true) {
            System.out.println("\033[2J"); // clear character
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
                    ArrayList<String >studentArray = new ArrayList<>();
                    for (Entry<String, Status> s : students.entrySet()) {
                    	if (s.getValue() == Status.PRESENT) {
                    		studentArray.add(s.getKey());
                    	}
                    }
//                    studentArray = new ArrayList<String>(sort(Arrays.asList(studentArray).toArray())); this would be how the sorting algorithm could be implemented
                    
                    System.out.println("Report:");
                    for (String s: studentArray) {
                    	writer.write(s + "\n");
                    }
                    writer.append("Present students have been marked.");
                    writer.close();
                    System.out.println("Report has been generated.");
                    break;
                case "Q":
                    System.out.println("Quit?");
                    if (reader.nextLine() == "Y") {
                        return;
                    }
                    continue;
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
