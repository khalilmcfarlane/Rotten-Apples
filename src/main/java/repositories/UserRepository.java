package repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Profile;

import models.User;
@Repository
@Profile("mongodb")
public interface UserRepository extends MongoRepository<User, UUID> {
    
}
