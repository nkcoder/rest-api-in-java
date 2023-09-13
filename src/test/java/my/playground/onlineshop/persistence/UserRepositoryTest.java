package my.playground.onlineshop.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;
import my.playground.onlineshop.persistence.entity.UserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
@Disabled(value = "H2 converts table/fields names to uppercase, so it cannot find table: users (candidate is USERS)")
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @BeforeEach
  public void setup() {

  }

  @Test
  public void shouldFindUserByEmail() {
    UserEntity newUser = new UserEntity(
        "Daniel",
        "daniel@gmail.com",
        "PassW0rd!",
        "Admin",
        LocalDateTime.now()
    );
    userRepository.save(newUser);

    Optional<UserEntity> maybeUser = userRepository.findByEmail("daniel@gmail.com");
    assertTrue(maybeUser.isPresent());

    UserEntity userFound = maybeUser.get();
    assertEquals("Daniel", userFound.getUserName());
    assertEquals("Admin", userFound.getUserType());
  }

  @AfterEach
  public void teardown() {

  }
}