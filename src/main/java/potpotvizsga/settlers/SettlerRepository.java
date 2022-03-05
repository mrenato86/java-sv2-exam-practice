package potpotvizsga.settlers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

public class SettlerRepository {

    private final JdbcTemplate jdbcTemplate;

    public SettlerRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long saveNewSettler(Settler settler) {
        String sql = "INSERT INTO settlers(name_of_settler, amount_of_tobacco, expected_income) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, settler.getNameOfSettler());
                    ps.setInt(2, settler.getAmountOfTobacco());
                    ps.setInt(3, settler.getExpectedIncome());
                    return ps;
                }, keyHolder
        );
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public Settler findSettlerById(long id) {
        String sql = "SELECT id,name_of_settler, amount_of_tobacco, expected_income FROM settlers WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, getSettlerRowMapper(), id);
    }

    private RowMapper<Settler> getSettlerRowMapper() {
        return (rs, rowNum) -> new Settler(
                rs.getLong("id"),
                rs.getString("name_of_settler"),
                rs.getInt("amount_of_tobacco"),
                rs.getInt("expected_income"));
    }

    public void updateGrowthAndIncome(long id, int amount) {
        String sql = "UPDATE settlers SET amount_of_tobacco = amount_of_tobacco - ?, expected_income = expected_income - ? WHERE id = ?";
        jdbcTemplate.update(sql, amount, amount * Settler.INCOME_BY_TONS, id);
    }
}
