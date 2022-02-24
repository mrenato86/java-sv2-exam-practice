package dogtypes;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class DogTypes {

    JdbcTemplate jdbcTemplate;

    public DogTypes(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getDogsByCountry(String country) {
        String sql = "SELECT Lower(name) as low_name FROM dog_types WHERE country = ? ORDER BY name";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("low_name"), country.toUpperCase());
    }

//    public List<String> getDogsByCountry2(String country) {
//        String sql = "SELECT Lower(name) as low_name FROM dog_types WHERE country = ? ORDER BY name";
//        try (
//                Connection conn = jdbcTemplate.getDataSource().getConnection();
//                PreparedStatement stmt = conn.prepareStatement(sql);
//        ) {
//            stmt.setString(1, country.toUpperCase());
//
//            return getNamesFromResult(stmt);
//        } catch (SQLException se) {
//            throw new IllegalArgumentException("Error in query!", se);
//        }
//    }
//
//    public List<String> getNamesFromResult(PreparedStatement stmt) throws SQLException {
//        List<String> result = new ArrayList<>();
//        try (ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                String name = rs.getString("low_name");
//                result.add(name);
//            }
//        }
//        return result;
//    }

}
