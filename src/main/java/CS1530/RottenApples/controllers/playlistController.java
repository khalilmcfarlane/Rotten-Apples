package CS1530.RottenApples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS1530.RottenApples.models.*;
import CS1530.RottenApples.repositories.*;
import java.util.*;

@Controller
@RequestMapping()
public class playlistController {
    private PlaylistRepository playlistRepository;
    private UserRepository userRepository;
    private MovieRepository movieRepository;
    //private FriendRequestRepository friendRequestRepository;

    public void addMovies(String movieTitle){
    Movie currMovie= movieRepository.findMovie(movieTitle);

    }

    public void addFriendsToPlaylist(){
        
       

    }
}