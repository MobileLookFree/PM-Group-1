package ivbo02151.demo.dao;

    import ivbo02151.demo.model.StudyGroup;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.stereotype.Repository;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.List;

@Repository
public class StudyGroupJdbc {

    private final JdbcTemplate jdbcTemplate;

    public StudyGroupJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudyGroup get(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM study_group WHERE id = ?", this::mapGroup, id);
    }

    //добавлен метод для поиска по названию группы на латинице
    public StudyGroup search(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM study_group WHERE name = ?", this::mapGroup, name);
    }

    public List<StudyGroup> getAll() {
        return jdbcTemplate.query("SELECT * FROM study_group", this::mapGroup);
    }

    public int add(int id, String name) {
        return jdbcTemplate.update("INSERT INTO STUDY_GROUP VALUES ( ?, ? )", id, name);
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM STUDY_GROUP WHERE ID=?", id);
    }

    public int setName(int id, String name) {
        return jdbcTemplate.update("UPDATE STUDY_GROUP SET NAME=? WHERE ID=?", name, id);
    }

    private StudyGroup mapGroup(ResultSet rs, int i ) throws SQLException {
        StudyGroup group = new StudyGroup(
                rs.getInt("id"),
                rs.getString("name")
        );
        return group;
    }
}
