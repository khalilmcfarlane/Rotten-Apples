package CS1530.RottenApples.repositories;

import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import CS1530.RottenApples.models.Playlist;



 @Repository
 public interface PlaylistRepository extends MongoRepository<Playlist, Integer> { 
    Playlist findbyPlaylist(String playlistTitle);
 }
