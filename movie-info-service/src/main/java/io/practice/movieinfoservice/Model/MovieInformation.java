package io.practice.movieinfoservice.Model;

public class MovieInformation {
    private String movieName;
    private String movieDesc;

    public MovieInformation(String movieName, String movieDesc) {
        this.movieName = movieName;
        this.movieDesc = movieDesc;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }
}
