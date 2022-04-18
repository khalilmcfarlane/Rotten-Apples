package CS1530.RottenApples;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import CS1530.RottenApples.models.Movie;
import CS1530.RottenApples.models.Playlist;
import CS1530.RottenApples.repositories.MovieRepository;
import CS1530.RottenApples.repositories.PlaylistRepository;

@SpringBootApplication
public class RottenApplesApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(RottenApplesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	}

}
