package CS1530.RottenApples.impl;
import java.util.UUID;

import CS1530.RottenApples.models.User;
import CS1530.RottenApples.repositories.UserRepository;

public class UserImpl {
    private UserRepository userRepository;


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
}
