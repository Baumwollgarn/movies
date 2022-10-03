import domain.Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/Movies",
                        "root", "Alex2002");

        if (conn != null) {
            System.out.println("Connected to the database!");
        } else {
            System.out.println("Failed to make connection!");
        }

        assert conn != null;
        Statement sta = conn.createStatement();

        ResultSet result = sta.executeQuery("SELECT * FROM Movie");

        Movie m1;
        List<Movie> movies = new ArrayList<Movie>();

        while (result.next()) {
            try {
                m1 = new Movie(result.getInt("id"), result.getString("title"), result.getInt("year"), result.getString("director"), result.getString("genre"));
                movies.add(m1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (Movie m : movies) {
            System.out.println(m.getTitle());
        }
    }

}
