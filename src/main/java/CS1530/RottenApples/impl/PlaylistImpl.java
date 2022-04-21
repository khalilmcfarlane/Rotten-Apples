package CS1530.RottenApples.impl;
import java.util.*;
import CS1530.RottenApples.models.*;
import CS1530.RottenApples.repositories.*;

public class PlaylistImpl {
    private MovieRepository movieRepository;
    private PlaylistRepository playlistRepository;

    public void addToPlaylist(int playlistId, String movieTitle) {
        Playlist playlist = playlistRepository.findById(playlistId).get();
        Movie movie = movieRepository.findMovie(movieTitle);
        playlist.getMovieTitles().add(movie);
        playlistRepository.save(playlist);
    }

    public void save(Playlist playlist) {
        playlistRepository.save(playlist);
    }
}
