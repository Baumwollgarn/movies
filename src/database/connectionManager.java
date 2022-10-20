package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class connectionManager {
    private static Connection con;

    public static Connection getConnection() {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            try {
                String username = "root";
                String password = "PASSWORD";
                String url = "jdbc:mysql://localhost:3306/Movies";
                con = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}
