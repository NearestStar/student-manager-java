import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewStudents {
    public static void main(String[] args) {
        try{
            Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db",
                "root",
                "1234" 
            );

            String query="SELECT * FROM students";

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery(query);

            System.out.println("Student List: ");

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");

                System.out.println(id+" | "+name+" | "+age);
            }

            rs.close();
            st.close();
            con.close();

        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
}
