package CS1530.RottenApples.models;

import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User { 
    @Id
    private UUID id;
    private String username;
    private String password;

    public User() {
        
    }

    public User(UUID id, String username, String password) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UUID getId() {
        return id;
    }
    /*
    This will go in a controller class
    public void login(String username, String password) {
        //skeleton
    }

    public void signout() {
        //skeleton
    }

    public void addFriend(String username) {
        //skeleton
    }

    public void inviteUser(String username, String playlist) {
        //skeleton
    }

    public String displayFriends() {

        //skeleton
        return "";
    }

    public void createPlaylist() {
        //skeleton
    }

    public boolean acceptInvite(String invite) {
        //skeleton
        return false;
    }

    */
}
