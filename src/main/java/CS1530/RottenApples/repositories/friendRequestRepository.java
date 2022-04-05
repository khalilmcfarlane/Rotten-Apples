package CS1530.RottenApples.repositories;
import CS1530.RottenApples.models.friendRequest;
import CS1530.RottenApples.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestRepository extends MongoRepository<friendRequest, Long> {
    @Query("{'recipient' : ?0, 'sender' : ?1}")
    friendRequest findFriend(User recipient, User sender);
}
