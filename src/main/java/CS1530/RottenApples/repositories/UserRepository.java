package CS1530.RottenApples.repositories;

import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import CS1530.RottenApples.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> { 
    @Query("{'username' : ?0, 'password' : ?1}")
    User findByUser(String username, String password);
<<<<<<< HEAD

    @Query("{'username' : ?0}")
    User findByName(String username);
=======
    @Query("{'username' : ?0}")
    User findFriend(String username);
>>>>>>> c58dc46bfd271bb0f910d7408fa56705726931df
}
