package potvizsga.message;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserRepositoryTest {


    Flyway flyway;
    UserRepository userRepository;

    @BeforeEach
    void init() {

        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/e_messages?useUnicode=true");
            dataSource.setUser("examuser");
            dataSource.setPassword("exampass");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot reach DataBase!", sqle);
        }

        flyway = Flyway.configure().locations("potvizsga/db/migration").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        userRepository = new UserRepository(dataSource);

    }

    @Test
    void insertUser() {
        userRepository.insertUser("johnDoe");
        userRepository.insertUser("janeDoe");
        Optional<User> find = userRepository.findUserByName("johnDoe");

        assertEquals("johnDoe", find.get().getUsername());
    }

    @Test
    void findUserTest() {
        userRepository.insertUser("johnDoe");
        userRepository.insertUser("janeDoe");
        Optional<User> find = userRepository.findUserByName("BillDoe");

        assertTrue(find.isEmpty());

    }

}