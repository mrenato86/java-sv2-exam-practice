package peoplesql;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class PeopleDao {

    private final JdbcTemplate jdbcTemplate;

    public PeopleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String findIpByName(String firstName, String lastName) {
        String sql = "SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> rs.getString("ip_address"), firstName, lastName);
    }

}
