import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db",
                "root",
                "1234"
            );

            System.out.println("✅ Connected to Database!");

            con.close();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e);
        }
    }
}