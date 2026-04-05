import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertStudent {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try{
            Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", 
                "root", 
                "1234"
            );

            System.out.println("Enter name: ");
            String name=sc.nextLine();

            System.out.println("Enter age: ");
            int age=sc.nextInt();

            String query="INSERT INTO students (name, age) VALUES (?,?)";

            PreparedStatement pst=con.prepareStatement(query);

            pst.setString(1, name);
            pst.setInt(2, age);

            pst.executeUpdate();

            System.out.println("Student inserted into databse!");

            pst.close();
            con.close();
            sc.close();

        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
}
