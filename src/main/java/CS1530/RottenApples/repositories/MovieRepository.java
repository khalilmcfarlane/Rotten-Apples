package CS1530.RottenApples.repositories;

import CS1530.RottenApples.models.Movie;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {
    @Query("{'title' : ?0}")
    Movie findMovie(String title);


    @Query("{ 'title' : { $regex: ?0 } }")
    List<Movie> findMovieRegex(String regex);

    public List<Movie> findAllByOrderByTitleAsc();
}
