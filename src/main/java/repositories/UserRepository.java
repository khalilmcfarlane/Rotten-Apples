package repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import models.User;

public interface UserRepository extends MongoRepository<User, UUID> {
    
}
