package data;

import java.util.List;

public interface IAccessData {

    public void addMovie();

    public void listMovies();

    public void deleteMovie();

    public void searchMovie();

    public List<String> getMovies(String tableName);

}
