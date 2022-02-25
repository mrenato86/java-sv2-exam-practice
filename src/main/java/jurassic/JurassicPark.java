package jurassic;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JurassicPark {

    private final JdbcTemplate jdbcTemplate;

    public JurassicPark(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> checkOverpopulation() {
        String sql = "SELECT breed FROM dinosaur WHERE actual > expected ORDER BY breed";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("breed"));
    }
}
