package housecup;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Objects;

public class HouseCup {

    private final JdbcTemplate jdbcTemplate;

    public HouseCup(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getPointsOfHouse(String house) {
        String sql = "SELECT SUM(points_earned) FROM house_points WHERE house_name = ?";
        return Objects.requireNonNull(jdbcTemplate.queryForObject(sql, (rs, rowNum) -> rs.getInt(1), house));
    }
}
