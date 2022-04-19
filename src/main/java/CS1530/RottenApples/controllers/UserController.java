package CS1530.RottenApples.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import CS1530.RottenApples.impl.FriendImpl;
import CS1530.RottenApples.models.Playlist;
import CS1530.RottenApples.models.User;
import CS1530.RottenApples.models.friendRequest;
import CS1530.RottenApples.repositories.FriendRequestRepository;
import CS1530.RottenApples.repositories.UserRepository;
//import friendRequest and friendRepository

@RestController
public class UserController {
    private UserRepository userRepository;
    //private FriendRequestRepository friendRepository;

    public void register(String username, String password) {
        userRepository.save(new User(UUID.randomUUID(), username, password));
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUser(username, password);

        if(user.getUsername() != null && user.getPassword() != null) {
            return true;
        }
        return false;
    }

    public void signout() {
        //skeleton
    }

    public void displayFriends(User user) {
        FriendImpl friend = new FriendImpl(); 
        List<friendRequest> friends = friend.getFriends(user); //get the friends of this user
        for(friendRequest reqs : friends) {
            System.out.print(reqs.toString().replaceAll("[]", ""));
        }
    }
     
    public void createPlaylist() {
        //skeleton
        Playlist user = new Playlist();
        user.setPlaylistTitle("How can I make this generic?");
        //user.addMovieToPlaylist();
        //user.addFriendToPlaylist();
        //blah, blah
    }
}
