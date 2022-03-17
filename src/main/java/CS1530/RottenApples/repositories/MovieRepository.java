package CS1530.RottenApples.repositories;

import CS1530.RottenApples.models.Movie;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {
    
}
