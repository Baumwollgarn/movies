package business;

import data.AccessDataImp;
import database.connectionManager;
import domain.Movie;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MovieList implements IMovieList {

    public MovieList() throws SQLException {
        this.accessDataImp = new AccessDataImp();
    }
    private final AccessDataImp accessDataImp;
    @Override
    public void listMovies() throws SQLException {
        List<Movie> movies = accessDataImp.getMovies("Movie");

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    @Override
    public void addMovie() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("----- Add movie -----");
        Movie movie = new Movie();
        getInfo(scanner, reader, movie);

        accessDataImp.addMovie(movie);
        System.out.println("Movie added successfully");
    }

    private void getInfo(Scanner scanner, BufferedReader reader, Movie movie) throws IOException {
        System.out.println("Enter the movie title: ");
        movie.setTitle(reader.readLine());
        System.out.println("Enter the year of release: ");
        movie.setYear(scanner.nextInt());
        System.out.println("Enter the director: ");
        movie.setDirector(reader.readLine());
        System.out.println("Enter the movie genre: ");
        movie.setGenre(reader.readLine());
    }

    @Override
    public void initList() {

    }

    @Override
    public void searchMovie() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the column you want to search for: ");
            String column = br.readLine();
            System.out.println("Enter the value you want to search for: ");
            String value = br.readLine();
            List<Movie> movies = accessDataImp.getMovies("Movie");

            for (Movie movie : movies) {
                if (column.equals("title") && movie.getTitle().equals(value)) {
                    System.out.println(movie);
                } else if (column.equals("year") && movie.getYear() == Integer.parseInt(value)) {
                    System.out.println(movie);
                } else if (column.equals("director") && movie.getDirector().equals(value)) {
                    System.out.println(movie);
                } else if (column.equals("genre") && movie.getGenre().equals(value)) {
                    System.out.println(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMovie() throws SQLException {
        System.out.println("----- Delete movie -----");
        Scanner scanner = new Scanner(System.in);

        for (Movie movie : accessDataImp.getMovies("Movie")) {
            System.out.println(movie);
        }

        System.out.println("Enter the movie id to delete: ");
        int id = scanner.nextInt();
        Movie m1 = accessDataImp.existMovie(id);
        accessDataImp.deleteMovie(m1);
        System.out.println("Movie deleted successfully");
    }

    @Override
    public void updateMovie() throws SQLException, IOException {
        System.out.println("----- Update movie -----");
        Scanner scanner = new Scanner(System.in);

        for (Movie movie : accessDataImp.getMovies("Movie")) {
            System.out.println(movie);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the movie id to update: ");
        int id = scanner.nextInt();
        Movie m1 = accessDataImp.existMovie(id);
        getInfo(scanner, reader, m1);

        accessDataImp.editMovie(m1);
        System.out.println("Movie updated successfully");
    }

    @Override
    public void exportMovieList() throws SQLException, IOException {
        System.out.println("----- Export movie list -----");
        List<Movie> movies = accessDataImp.getMovies("Movie");
        try {
            FileWriter writer = new FileWriter("movieList.csv");
            writer.append("id");
            writer.append(",");
            writer.append("title");
            writer.append(",");
            writer.append("year");
            writer.append(",");
            writer.append("director");
            writer.append(",");
            writer.append("genre");
            writer.append("\n");
            for (Movie movie : movies) {
                writer.append(String.valueOf(movie.getId()));
                writer.append(",");
                writer.append(movie.getTitle());
                writer.append(",");
                writer.append(String.valueOf(movie.getYear()));
                writer.append(",");
                writer.append(movie.getDirector());
                writer.append(",");
                writer.append(movie.getGenre());
                writer.append("\n");
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Movie list exported successfully");
    }

    @Override
    public void exportMovie() throws SQLException, IOException {
        System.out.println("----- Export movie -----");
        Scanner scanner = new Scanner(System.in);

        for (Movie movie : accessDataImp.getMovies("Movie")) {
            System.out.println(movie);
        }

        System.out.println("Enter the movie id to export: ");
        int id = scanner.nextInt();
        Movie m1 = accessDataImp.existMovie(id);
        try {
            FileWriter writer = new FileWriter("movie.csv");
            writer.append("id");
            writer.append(",");
            writer.append("title");
            writer.append(",");
            writer.append("year");
            writer.append(",");
            writer.append("director");
            writer.append(",");
            writer.append("genre");
            writer.append("\n");
            writer.append(String.valueOf(m1.getId()));
            writer.append(",");
            writer.append(m1.getTitle());
            writer.append(",");
            writer.append(String.valueOf(m1.getYear()));
            writer.append(",");
            writer.append(m1.getDirector());
            writer.append(",");
            writer.append(m1.getGenre());
            writer.append("\n");
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Movie exported successfully");
    }

    @Override
public void importMovieList() throws SQLException, IOException {
        System.out.println("----- Import movie list -----");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("movieList.csv"));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Movie movie = new Movie();
                movie.setTitle(values[1]);
                movie.setYear(Integer.parseInt(values[2]));
                movie.setDirector(values[3]);
                movie.setGenre(values[4]);
                accessDataImp.addMovie(movie);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Movie list imported successfully");
    }
}
