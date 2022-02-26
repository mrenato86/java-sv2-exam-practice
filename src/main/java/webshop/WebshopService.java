package webshop;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class WebshopService {

    private final JdbcTemplate jdbcTemplate;

    public WebshopService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getValuableCustomers() {
        String sql = "SELECT customer_name FROM orders WHERE total>1000 ORDER BY customer_name";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("customer_name"));
    }
}
