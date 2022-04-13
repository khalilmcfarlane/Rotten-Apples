package CS1530.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import CS1530.RottenApples.models.User;
import CS1530.RottenApples.repositories.UserRepository;
//import friendRequest and friendRepository

@RestController
public class UserController {
    private UserRepository userRepository;
    //private friendRepository friendRepository;

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

    /*public void signout() {
        //skeleton
    }*/

    //I think the playlist will be an object
    public void inviteUser(String username, String playlist) {
        //skeleton
    }

    public void displayFriends(User user) {
        /*
        FriendImpl friend = new FriendImpl(); 
        ArrayList<friendRequest> friends = friend.getFriends(user); get the friends of this user
        for(friendRequest reqs : friends) {
            System.out.print(reqs);
        }
        */
        //return "";
    }
    //HOW - is this a database task?  
    public void createPlaylist() {
        //skeleton
    }

    //May change to type friendRequest; may also need recipient
    public boolean acceptInvite(String invite, User recipient) {
        //friendRequest request = new friendRequest();
        if(invite.equals("A friend has invited you to edit a playlist.")) {
            // return request.setAccepted(true);
            return true;
        }
        return false;
    }

    public void sendFriendRequest() {
    }
}
