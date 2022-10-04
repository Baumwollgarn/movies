package data;

import domain.Movie;

import java.sql.SQLException;
import java.util.List;

public interface IAccessData {
    public boolean existMovie(int id) throws SQLException;
    public void addMovie(Movie movie);

    public void editMovie(Movie movie);

    void listMovie(Movie movie);

    public void deleteMovie(Movie movie);

    public void searchMovie(Movie movie);
    /* ArrayList of all movies in the database */
    public List<Movie> getMovies(String tableName);

}
