package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection conn = null;

    public static Connection getConnection() {

        try {
        	Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:C:\\Users\\Dani\\eclipse-workspace\\Warehouse_pr\\Warehouse\\h2","sa","123");

        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }
}
