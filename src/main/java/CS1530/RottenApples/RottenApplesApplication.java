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

	@Override
	public void run(String... args) throws Exception {
		if(userRepository.findAll().isEmpty()) {
			UUID id = UUID.randomUUID();
			userRepository.save(new User(id, "cs4life", "zxkj12rj2r"));
		}
	}

}
