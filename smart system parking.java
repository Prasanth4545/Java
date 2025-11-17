import java.util.*;
public class CourseEnrollmentSystem {
private static Map<String, Set<String>> courses = new HashMap<>();
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int choice;
do {
System.out.println("\n==========================================")
;
System.out.println(" ONLINE COURSE ENROLLMENT SYSTEM");
System.out.println("==========================================");
System.out.println("1. Create Course");
System.out.println("2. Enroll Student");
System.out.println("3. Remove Student");
System.out.println("4. Display Students in Course");
System.out.println("5. Find Common Students");
System.out.println("6. Find Unique Students");
System.out.println("7. Exit");
System.out.print("-------------------------------------------
\nEnter your choice: ");
choice = sc.nextInt();
sc.nextLine();
switch (choice) {
case 1 -> createCourse(sc);
case 2 -> enrollStudent(sc);
case 3 -> removeStudent(sc);
case 4 -> displayCourseStudents(sc);
case 5 -> findCommonStudents(sc);
case 6 -> findUniqueStudents(sc);
case 7 -> System.out.println("Exiting...");
default -> System.out.println("Invalid choice. Try again.");
}
} while (choice != 7);
System.out.println("Reg. No: 23BBS0071");
sc.close();
}
private static void createCourse(Scanner sc) {
System.out.print("Enter Course Name: ");
String courseName = sc.nextLine();
if (courses.containsKey(courseName)) {
System.out.println("Course already exists!");
} else {
courses.put(courseName, new HashSet<>());
System.out.println("Course created successfully!");
}
}
private static void enrollStudent(Scanner sc) {
System.out.print("Enter Course Name: ");
String courseName = sc.nextLine();
if (!courses.containsKey(courseName)) {
System.out.println("Course does not exist!");
} else {
System.out.print("Enter Student ID: ");
String studentId = sc.nextLine();
if (courses.get(courseName).add(studentId)) {
System.out.println("Student enrolled successfully!");
} else {
System.out.println("Student is already enrolled in this
course!");
}
}
}
private static void removeStudent(Scanner sc) {
System.out.print("Enter Course Name: ");
String courseName = sc.nextLine();
if (!courses.containsKey(courseName)) {
System.out.println("Course does not exist!");
} else {
System.out.print("Enter Student ID: ");
String studentId = sc.nextLine();
if (courses.get(courseName).remove(studentId)) {
System.out.println("Student removed successfully!");
} else {
System.out.println("Student not found in this course!");
}
}
}
private static void displayCourseStudents(Scanner sc) {
System.out.print("Enter Course Name: ");
String courseName = sc.nextLine();
if (!courses.containsKey(courseName)) {
System.out.println("Course does not exist!");
} else {
Set<String> students = courses.get(courseName);
if (students.isEmpty()) {
System.out.println("No students enrolled in this course.");
} else {
System.out.println("\nStudents in " + courseName + ":");
System.out.println("------------------------------------------
----------");
for (String student : students) {
System.out.println("- " + student);
}
System.out.println("------------------------------------------
----------");
}
}
}
private static void findCommonStudents(Scanner sc) {
System.out.print("Enter First Course Name: ");
String course1 = sc.nextLine();
System.out.print("Enter Second Course Name: ");
String course2 = sc.nextLine();
if (!courses.containsKey(course1) || !courses.containsKey(course2)) {
System.out.println("One or both courses do not exist!");
} else {
Set<String> common = new HashSet<>(courses.get(course1));
common.retainAll(courses.get(course2));
System.out.println("\nCommon Students in " + course1 + " and " +
course2 + ":");
System.out.println("----------------------------------------------
------");
if (common.isEmpty()) {
System.out.println("No common students found.");
} else {
for (String student : common) {
System.out.println("- " + student);
}
}
System.out.println("----------------------------------------------
------");
}
}
private static void findUniqueStudents(Scanner sc) {
System.out.print("Enter First Course Name: ");
String course1 = sc.nextLine();
System.out.print("Enter Second Course Name: ");
String course2 = sc.nextLine();
if (!courses.containsKey(course1) || !courses.containsKey(course2)) {
System.out.println("One or both courses do not exist!");
} else {
Set<String> unique1 = new HashSet<>(courses.get(course1));
unique1.removeAll(courses.get(course2));
Set<String> unique2 = new HashSet<>(courses.get(course2));
unique2.removeAll(courses.get(course1));
System.out.println("\nUnique Students in " + course1 + ":");
System.out.println("----------------------------------------------
------");
if (unique1.isEmpty()) {
System.out.println("No unique students.");
} else {
for (String student : unique1) {
System.out.println("- " + student);
}
}
System.out.println("\nUnique Students in " + course2 + ":");
System.out.println("----------------------------------------------
------");
if (unique2.isEmpty()) {
System.out.println("No unique students.");
} else {
for (String student : unique2) {
System.out.println("- " + student);
}
}
System.out.println("----------------------------------------------
------");
}
}
