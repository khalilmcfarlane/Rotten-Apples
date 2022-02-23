package models;
import java.util.*;
import org.springframework.data.annotation.Id;

public class User { 
    @Id
    private UUID id;

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
}
