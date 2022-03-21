package CS1530.RottenApples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import CS1530.RottenApples.models.Movie;
import CS1530.RottenApples.models.User;
import CS1530.RottenApples.repositories.MovieRepository;
import CS1530.RottenApples.repositories.UserRepository;



@SpringBootApplication
public class RottenApplesApplication implements CommandLineRunner{
	private final UserRepository userRepository;
	private MovieRepository movieRepository;

	@Autowired
	public RottenApplesApplication(UserRepository userRepository, MovieRepository movieRepository) {
		this.userRepository = userRepository;
		this.movieRepository = movieRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(RottenApplesApplication.class, args);
	}

	// This can be used for MongoRepo stuff we want to do
	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
