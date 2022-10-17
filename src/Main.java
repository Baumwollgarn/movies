import business.MovieList;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


public class Main {

    public static void menu() {
        System.out.println(" What do you want to do? ");
        System.out.println(" 1. List movies ");
        System.out.println(" 2. Add movie ");
        System.out.println(" 3. Delete movie ");
        System.out.println(" 4. Update movie ");
        System.out.println(" 5. Search movie ");
        System.out.println(" 6. Export complete movie list ");
        System.out.println(" 7. Export movie ");
        System.out.println(" 8. Import movie list ");
        System.out.println(" 9. Exit ");
        System.out.print("Enter your choice: ");
    }
    public static void main(String[] args) throws SQLException, IOException {

        do {
            menu();
            MovieList movieList = new MovieList();
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    movieList.listMovies();
                    break;
                case "2":
                    movieList.addMovie();
                    break;
                case "3":
                    movieList.deleteMovie();
                    break;
                case "4":
                    movieList.updateMovie();
                    break;
                case "5":
                    movieList.searchMovie();
                    break;
                case "6":
                    movieList.exportMovieList();
                    break;
                case "7":
                    movieList.exportMovie();
                    break;
                case "8":
                    movieList.importMovieList();
                    break;
                case "9":
                    System.out.println("Thanks for using the app, hope to see you soon!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (true);
    }
}

