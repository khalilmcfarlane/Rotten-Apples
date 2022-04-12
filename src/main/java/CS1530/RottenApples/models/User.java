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

    List<String> following = new ArrayList<>();

    List<String> followers = new ArrayList<>();
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

    public void setUser(String user) {
        username = user;

    }


    public void setPassword(String pass) {
        password = pass;

    }

    public int getFollowing() {
        return following.size();
    }

    public int getFollowers() {
        return followers.size();
    }
      
}
