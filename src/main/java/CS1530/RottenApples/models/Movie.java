package CS1530.RottenApples.models;


import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movies")
public class Movie {
    @Id 
    private int id;
    private String title;
    private String genre;
    private String releaseDate;
    private String poster;

    public Movie() {

    }

    public Movie(int id, String title, String genre, String releaseDate, String poster) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.poster = poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    public List<User> usersWhoWatched(int movieId) {
        List<User> users = new ArrayList<User>();
        //template for now
        users.add(new User(UUID.randomUUID(), "cs4life", "zxkj12rj2r"));
        return users;
    }
}


