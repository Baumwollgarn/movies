package data;

import database.connectionManager;
import domain.Movie;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AccessDataImp implements IAccessData {

    public AccessDataImp() throws SQLException {
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Movie");
    }

    @Override
    public boolean existMovie(int id) throws SQLException {
        Connection con = connectionManager.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Movie WHERE id = " + id);
        return rs.next();
    }

    @Override
    public void addMovie(Movie movie) {
        try {
            Connection con = connectionManager.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Movie (title, year, director, genre) VALUES ('" + movie.getTitle() + "', " + movie.getYear() + ", '" + movie.getDirector() + "', '" + movie.getGenre() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listMovie(Movie movie) {
        try {
            Connection con = connectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Movie WHERE id = " + movie.getId() );
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " Title: " + rs.getString("title") + " Year: " + rs.getInt("year") + " Director: " + rs.getString("director") + " Genre: " + rs.getString("genre"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMovie(Movie movie) {
        try {
            Connection con = connectionManager.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Movie WHERE id = " + movie.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchMovie(Movie movie) {
        try {
            Connection con = connectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Movie WHERE title = " + movie.getTitle() );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editMovie(Movie movie) {
        try {
            Connection con = connectionManager.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE Movie SET title = '" + movie.getTitle() + "', year = " + movie.getYear() + ", director = '" + movie.getDirector() + "', genre = '" + movie.getGenre() + "' WHERE id = " + movie.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> getMovies(String tableName) {
        try {
            Connection con = connectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            Movie m1;
            List<Movie> movies = new ArrayList<Movie>();

            while (rs.next()) {
                try {
                    m1 = new Movie(rs.getInt("id"), rs.getString("title"), rs.getInt("year"), rs.getString("director"), rs.getString("genre"));
                    movies.add(m1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
