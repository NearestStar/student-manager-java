import java.util.*;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Main {

    // 🔹 Add Student
    public static void addStudent(ArrayList<Student> students, Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        students.add(new Student(name, age));
        System.out.println("Student added!");
    }

    // 🔹 View Students
    public static void viewStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                System.out.println(i + ". " + s.name + " - " + s.age);
            }
        }
    }

    // 🔹 Delete Student
    public static void deleteStudent(ArrayList<Student> students, Scanner sc) {
        System.out.print("Enter index to delete: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index >= 0 && index < students.size()) {
            students.remove(index);
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // 🔹 Search Student
    public static void searchStudent(ArrayList<Student> students, Scanner sc) {
        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (Student s : students) {
            if (s.name.equalsIgnoreCase(searchName)) {
                System.out.println("Found: " + s.name + " - " + s.age);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // 🔹 Update Student
    public static void updateStudent(ArrayList<Student> students, Scanner sc) {
        System.out.print("Enter index to update: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index >= 0 && index < students.size()) {
            Student s = students.get(index);

            System.out.print("Enter new name: ");
            s.name = sc.nextLine();

            System.out.print("Enter new age: ");
            s.age = sc.nextInt();
            sc.nextLine();

            System.out.println("Updated successfully!");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent(students, sc);
                    break;
                case 2:
                    viewStudents(students);
                    break;
                case 3:
                    deleteStudent(students, sc);
                    break;
                case 4:
                    searchStudent(students, sc);
                    break;
                case 5:
                    updateStudent(students, sc);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}