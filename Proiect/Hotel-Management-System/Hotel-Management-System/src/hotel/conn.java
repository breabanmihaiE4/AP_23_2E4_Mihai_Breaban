
package hotel;


import java.sql.*;

public class conn {
    Connection c;
    Statement statemant;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hms", "root", "mysql123");

            statemant = c.createStatement();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}  

