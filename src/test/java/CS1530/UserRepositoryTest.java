package CS1530;

import repositories.UserRepository;
import models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class UserRepositoryTest {
    
    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldStoreUser() {
        User user = new User(UUID.randomUUID(), "John Smith", "1234");
        userRepository.save(user);
        User storedUser = userRepository.findById(user.getId()).orElseThrow();
        assertThat(storedUser.getId()).isEqualTo(user.getId());
        assertThat(storedUser.getUsername()).isEqualTo(user.getUsername());
        assertThat(storedUser.getPassword()).isEqualTo(user.getPassword());
    }
}
