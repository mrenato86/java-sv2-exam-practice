package potvizsga.message;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.Optional;

public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertUser(String username) {
        String sql = "INSERT INTO users (username) VALUES (?)";
        jdbcTemplate.update(sql, username);
    }

    public Optional<User> findUserByName(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, getUserRowMapper(), username));
        } catch (EmptyResultDataAccessException erdae) {
            return Optional.empty();
        }
    }

    private RowMapper<User> getUserRowMapper() {
        return (rs, rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("username"));
    }
}
