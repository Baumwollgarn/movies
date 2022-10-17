package domain;

public class Movie {
    private int id;
    private String title;
    private int year;
    private String director;
    private String genre;

    public Movie() {

    }

    public Movie(int id) {
        this.id = id;
    }

    public Movie(String title, int year, String director, String genre) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.genre = genre;
    }

    public Movie(int id, String titol, int any, String director, String genere) {
        this.id = id;
        this.title = titol;
        this.year = any;
        this.director = director;
        this.genre = genere;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie: " +
                "Title='" + title + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", id= " + id;
    }
}
