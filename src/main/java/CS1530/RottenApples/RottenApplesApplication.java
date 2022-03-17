package CS1530.RottenApples;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import CS1530.RottenApples.models.User;
import CS1530.RottenApples.repositories.UserRepository;



@SpringBootApplication
public class RottenApplesApplication implements CommandLineRunner{
	private final UserRepository userRepository;

	@Autowired
	public RottenApplesApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(RottenApplesApplication.class, args);
	}

	// This tests out MongoDB Atlas
	@Override
	public void run(String... args) throws Exception {
		if(userRepository.findAll().isEmpty()) {
			UUID id = UUID.randomUUID();
			userRepository.save(new User(id, "cs4life", "zxkj12rj2r"));
		}
	
		/*
		// IGNORE: JUST USE CSV
			OR just parse csv file and populate
			for i =1 to 20,000
				if request.id[i] == movies/latest.id
					break
				do rest of calculations below
			end loop
			OR
			set counter(i) = 1
			while id is not equal to id of movie/latest
				iterate thru each id starting at 1
				* api call for id
				* parse json
					* Store title, releaseDate, poster, id, genre, director in Movie() Object
				* Do this, which creates a new Movie() for every movie
				* sleep thread for 1 sec after every request to prevent req limit
				* increment i

		*/
	}

}
