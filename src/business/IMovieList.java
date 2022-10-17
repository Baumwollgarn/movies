package business;

import java.io.IOException;
import java.sql.SQLException;

public interface IMovieList {
    public void listMovies() throws SQLException;

    public void addMovie() throws SQLException, IOException;

    public void initList();

    public void searchMovie();

    public void deleteMovie() throws SQLException;

    public void updateMovie() throws SQLException, IOException;

    public void exportMovieList() throws SQLException, IOException;
    public void exportMovie () throws SQLException, IOException;

    public void importMovieList() throws SQLException, IOException;
}
