import java.io.*;
import java.util.*;

class Student {
    String name;
    int rollNumber;
    String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNumber + ", Grade: " + grade;
    }

    public String toCSV() {
        return name + "," + rollNumber + "," + grade;
    }
}

public class StudentManagementSystem {
    static List<Student> studentList = new ArrayList<>();
    static final String FILE_NAME = "students.txt";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadFromFile();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Choose an option (1-5): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: addStudent(); break;
                case 2: removeStudent(); break;
                case 3: searchStudent(); break;
                case 4: displayAll(); break;
                case 5: saveToFile(); System.out.println("Exiting..."); return;
                default: System.out.println("Invalid option!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter roll number: ");
        int roll = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine().trim();

        if (name.isEmpty() || grade.isEmpty()) {
            System.out.println("Invalid input. Fields cannot be empty.");
            return;
        }

        studentList.add(new Student(name, roll, grade));
        System.out.println("Student added successfully.");
    }

    static void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        int roll = Integer.parseInt(scanner.nextLine());

        boolean removed = studentList.removeIf(s -> s.rollNumber == roll);
        System.out.println(removed ? "Student removed." : "Student not found.");
    }

    static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int roll = Integer.parseInt(scanner.nextLine());

        for (Student s : studentList) {
            if (s.rollNumber == roll) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void displayAll() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("\n-- Student List --");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    static void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    studentList.add(new Student(parts[0], Integer.parseInt(parts[1]), parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing data found.");
        }
    }

    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : studentList) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }
}
