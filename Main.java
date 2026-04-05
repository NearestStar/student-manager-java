import java.util.*;

class Student{
    String name;
    int age;
    Student(String name, int age){
        this.name=name;
        this.age=age;
    }
}

public class Main{

    public static void addStudent(ArrayList<Student> students, Scanner sc){
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> students=new ArrayList<>();



        // while(true){
        //     System.out.println("Menu");
        //     System.out.println("1. Enter the Student details");
        //     System.out.println("2. View the students");
        //     System.out.println("3. Delete the student");
        //     System.out.println("4. Exit");

        //     System.out.println("Enter the choice: ");
        //     int choice=sc.nextInt();
        //     sc.nextLine();

        //     switch(choice){
        //         case 1:
        //             System.out.println("Enter the name: ");
        //             String name=sc.nextLine();

        //             System.out.println("Enter the age: ");
        //             int age=sc.nextInt();
        //             sc.nextLine();

        //             students.add(new Student(name, age));
        //             System.out.println("Student Added!");

        //             break;

        //         case 2:
        //             if(students.isEmpty()){
        //                 System.out.println("Students List is Empty");
        //             }else{
        //                 for(Student s: students){
        //                     System.out.println("Name :"+s.name+", Age: "+s.age);
        //                 }
        //             }
        //             break;

        //         case 3:
        //             System.out.println("Enter the index to delete: ");
        //             int index=sc.nextInt();
        //             sc.nextLine();

        //             if(index>=0 && index<students.size()){
        //                 students.remove(index);
        //             }else{
        //                 System.out.println("Invalid Index");
        //             }
        //             break;

        //         case 4:
        //             System.out.println("Exiting...");
        //             sc.close();
        //             return;

        //         default:
        //             System.out.println("Enter valid choice");
        //     }
        // }
    }
}