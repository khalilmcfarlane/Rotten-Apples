package CS1530.RottenApples.repositories;

import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import CS1530.RottenApples.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> { 
    
}