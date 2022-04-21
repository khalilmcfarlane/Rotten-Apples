package CS1530.RottenApples.models;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Playlists")
public class Playlist {
    @Id
    private int id;
    private Movie movie;
    private User user;
    private String playlistTitle;
    List <Movie> movieTitles = new ArrayList<>();
    private boolean isPrivate;
    private int maxMovies = 15;
    private int moviesAdded;
    //ArrayList<Playlist Object> to store playlist objects?
    //HashMap/Hashtable to connect a friend (key) with a playlist (value)?  HashMap<Friend, ArrayList>

    public Playlist(){
        
    }

    public Playlist(String playlistTitle, int id) {
        this.playlistTitle = playlistTitle;
        this.id = id;
    }

    public Playlist(String playlistTitle, ArrayList <Movie> movieTitles, boolean isPrivate){
        this.playlistTitle= playlistTitle;
        this.isPrivate=false;
    }
/*
 code goes in Playlist Controller Class

    public void addMovies(String movieTitle){
        //add code to add movie titles to arraylist
        
        
    }
    

    public void addFriendsToPlaylist(){
        //
       

    }
*/
    
    public void setPrivate(boolean isPrivate){
        //true if private, false otherwise
       this.isPrivate = isPrivate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPrivate(){
        return isPrivate;
    }
    
    public Movie getMovies(){
        return movie;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
    public String getPlaylistTitle() {
        return playlistTitle;
    }

    public void setPlaylistTitle(String playlistTitle) {
        this.playlistTitle = playlistTitle;
    }

    public List<Movie> getMovieTitles() {
        return movieTitles;
    }

    public void setMovieTitles(List<Movie> movieTitles) {
        this.movieTitles = movieTitles;
    }


    public int getMoviesAdded() {
        return moviesAdded;
    }

    public void setMoviesAdded(int moviesAdded) {
        this.moviesAdded = moviesAdded;
    }

    public int getMaxMovies() {
        return maxMovies;
    }

    public void setMaxMovies(int maxMovies) {
        this.maxMovies = maxMovies;
    }

    public int moviesLeftToAdd(){
        return maxMovies-moviesAdded;
    }
}