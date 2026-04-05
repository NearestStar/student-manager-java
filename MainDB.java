import java.sql.*;
import java.util.Scanner;

public class MainDB {
    

    static final String URL="jdbc:mysql://localhost:3306/student_db";
    static final String USER="root";
    static final String PASS="1234";

    public static void addStudent(Scanner sc) throws Exception{
        Connection con=DriverManager.getConnection(URL, USER, PASS);

        System.out.println("Enter name: ");
        String name=sc.nextLine();

        System.out.println("Enter age: ");
        int age=sc.nextInt();
        sc.nextLine();

        String query="INSERT INTO students (name, age) VALUES (?,?)";
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1, name);
        pst.setInt(2, age);

        pst.executeUpdate();

        System.out.println("Student added to DB");

        pst.close();
        con.close();
    }

    // View Students

    public static void viewStudents() throws Exception{
        Connection con=DriverManager.getConnection(URL, USER, PASS);

        String query="SELECT * FROM students";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);

        System.out.println("\nStudent List:");
        while(rs.next()){
            System.out.println(rs.getInt("id")+" | "+
                                rs.getString("name")+" | "+
                                rs.getInt("age"));
        }

        rs.close();
        st.close();
        con.close();
    }

    // Delete Student
    public static void deleteStudent(Scanner sc)throws Exception{
        Connection con=DriverManager.getConnection(URL, USER, PASS);

        System.out.println("Enter ID to delete: ");
        int id=sc.nextInt();
        sc.nextLine();

        String query="DELETE FROM students WHERE id=?";
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1, id);

        int rows=pst.executeUpdate();

        if(rows>0){
            System.out.println("Deleted successfully");
        }else{
            System.out.println("ID not found");
        }

        pst.close();
        con.close();
    }

    // Update Student
    public static void updateStudent(Scanner sc) throws Exception{
        Connection con=DriverManager.getConnection(URL, USER, PASS);

        System.out.println("Enter ID to update: ");
        int id=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new name: ");
        String name=sc.nextLine();

        System.out.println("Enter new age: ");
        int age=sc.nextInt();
        sc.nextLine();

        String query="UPDATE students SET name=?, age=? WHERE id=?";
        PreparedStatement pst=con.prepareStatement(query);

        pst.setString(1, name);
        pst.setInt(2, age);
        pst.setInt(3, id);

        int rows=pst.executeUpdate();

        if(rows>0){
            System.out.println("Updated successfully");
        }else{
            System.out.println("ID not found");
        }

        pst.close();
        con.close();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        while(true){
           try {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Delete Student");
                System.out.println("4. Update Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addStudent(sc);
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        deleteStudent(sc);
                        break;
                    case 4:
                        updateStudent(sc);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("❌ Error: " + e);
            }
        }
    }
}
