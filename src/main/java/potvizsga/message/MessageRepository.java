package potvizsga.message;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MessageRepository {

    private final JdbcTemplate jdbcTemplate;

    public MessageRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertMessage(long senderId, long receiverId, String message) {
        String sql = "INSERT INTO messages (sender_id, receiver_id, message) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, senderId, receiverId, message);
    }

    public List<String> findMessagesBySenderId(long senderId) {
        String sql = "SELECT message FROM messages WHERE sender_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("message"), senderId);
    }

}
