package CS1530.RottenApples.models;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Playlists")
public class Playlist {
    @Id
    private String username;
    private String playlistTitle;
    private ArrayList <Movie> movieTitles = new ArrayList<Movie>();
    private boolean isPrivate;
    private final int maxMovies=15;
    private int moviesAdded;

    public Playlist(){
        
    }

    public Playlist(String username, String playlistTitle, ArrayList <Movie> movieTitles, boolean isPrivate, int moviesAdded){
        this.username=username;
        this.playlistTitle= playlistTitle;
        this.isPrivate=false;
        this.moviesAdded=moviesAdded;

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

    public boolean isPrivate(){
        return isPrivate;
    }
    
    public Movie getMovies(){
        return getMovies();
    }

    public User getUsers(){
        return getUsers();
    }
    
    public int moviesInPlaylist(){
        return maxMovies;
    }

    public int moviesLeftToAdd(){
        return moviesAdded;
    }
}