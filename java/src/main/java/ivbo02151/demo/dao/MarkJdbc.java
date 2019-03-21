package ivbo02151.demo.dao;

        import ivbo02151.demo.model.mark;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.stereotype.Repository;
        import java.sql.ResultSet;
        import java.sql.SQLException;


@Repository
public class MarkJdbc {
    private final JdbcTemplate jdbcTemplate;

    public MarkJdbc (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public mark get (int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM mark WHERE id = ?", this::mapMark, id);
    }

    private mark mapMark (ResultSet rs, int i) throws SQLException {
        mark mark = new mark (
                rs.getInt( "id"),
        rs.getString( "name"),
        rs.getString( "value")
        );

        return mark;
    }
    public mark search (String mark) {
        return jdbcTemplate.queryForObject("SELECT * FROM mark WHERE name = ?", mark.class, mark);
    }
}