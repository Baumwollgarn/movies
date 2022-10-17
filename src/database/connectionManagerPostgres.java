package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionManagerPostgres {

    private static Connection con;

    public static Connection getConnection() {
        try {
            String driverName = "org.postgresql.Driver";
            Class.forName(driverName);
            try {
                String username = "postgres";
                String password = "Alex2002";
                String url = "jdbc:postgresql://localhost:5432/Movies";
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