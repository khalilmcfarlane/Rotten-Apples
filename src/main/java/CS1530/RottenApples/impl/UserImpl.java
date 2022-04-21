package CS1530.RottenApples.impl;
import java.util.*;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;

import CS1530.RottenApples.models.User;
import CS1530.RottenApples.models.*;
import CS1530.RottenApples.repositories.*;

public class UserImpl {
    private UserRepository userRepository;
    private MovieRepository movieRepository;
    private MongoTemplate mongoTemplate;

    public void register(String username, String password) {
        userRepository.save(new User(UUID.randomUUID(), username, password));
    }

    public boolean login(String username, String password) {
        //userRepository is an instance of the UserRepository class, which queries MongoDB
        User user = userRepository.findByUser(username, password);

        /*if(user.getUsername() != null && user.getPassword() != null) {
            return true;
        }*/
        if(user != null) {
            return true;
        }
        return false;
    }
    
}
