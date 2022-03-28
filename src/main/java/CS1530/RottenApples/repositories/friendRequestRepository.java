package CS1530.RottenApples.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import CS1530.RottenApples.models.User;

public interface FriendRequestRepository extends MongoRepository<User, User> {
    
}
