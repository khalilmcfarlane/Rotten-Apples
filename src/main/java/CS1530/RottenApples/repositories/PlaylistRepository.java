package CS1530.RottenApples.repositories;

import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import CS1530.RottenApples.models.Movie;
import CS1530.RottenApples.models.Playlist;
import CS1530.RottenApples.models.User;



 @Repository
 public interface PlaylistRepository extends MongoRepository<Playlist, Integer> { 
   @Query("{'title' : ?0}")
    Playlist findbyPlaylist(String playlistTitle);

    //@Query("{'username' : ?0")
   // List<User> findUser(User user);

    List<Playlist> findByMovieTitles(List<Movie> movieTitles);



 }
