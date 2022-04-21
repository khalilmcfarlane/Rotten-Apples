package CS1530.RottenApples.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS1530.RottenApples.models.Movie;
import CS1530.RottenApples.models.Playlist;
import CS1530.RottenApples.repositories.MovieRepository;
import CS1530.RottenApples.repositories.PlaylistRepository;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Controller
//@RequestMapping("/playlists")
public class playlistController {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/playlists")
    public String getPlaylist(Model model) {
        List<Playlist> playlists =  playlistRepository.findAll();
        List<Movie> movies = movieRepository.findAllByOrderByTitleAsc();

        model.addAttribute("playlists", playlists);
        model.addAttribute("movies", movies);
        
        return "playlistInfo";
    }

    @PostMapping("/playlists")
    public String createPlaylistHome(String playlistTitle) {
        Playlist playlist = new Playlist();
        int rand = ThreadLocalRandom.current().nextInt(0, 1000);
        while(playlistRepository.existsById(rand)) {
            rand = ThreadLocalRandom.current().nextInt(0, 1000);
        }
        playlist.setId(rand);
        
        playlist.setPlaylistTitle(playlistTitle);
        playlistRepository.save(playlist);
        return "redirect:/playlists";
    }
    // Could call function that does all the work and then
    /*
    @RequestMapping("/createplaylist/creating")
    public String createNewPlaylist(@RequestParam("PlaylistName") String playlistTitle, Model model) {
        Playlist playlist = new Playlist();
        playlist.setId(sequenceGeneratorService.getNextSequence("customSequences"));
        playlist.setPlaylistTitle(playlistTitle);
        playlistRepository.save(playlist);
        model.addAttribute("Playlist", playlist);
        return "redirect:/playlists/" + playlist.getId();
    }

*/
   
    @PostMapping("/playlists/{playlistId}/movies")
    public String addMovieToPlaylist(@PathVariable int playlistId, @RequestParam("movieId") int movieId, Model model) {
        Playlist playlist = playlistRepository.findById(playlistId).get();

        //List<Movie> movieList = movieImpl.listAllMovies(movieTitle);
        //playlistImpl.addToPlaylist(id, movieTitle);
        Movie movie = movieRepository.findById(movieId).get();
        playlist.getMovieTitles().add(movie);
        model.addAttribute("moviesInPlaylist", playlist.getMovies());
        playlistRepository.save(playlist);
        int num_movies = playlist.getMoviesAdded();
        num_movies++;
        playlist.setMoviesAdded(num_movies);
        playlistRepository.save(playlist);
        return "redirect:/playlists";
    }
}
