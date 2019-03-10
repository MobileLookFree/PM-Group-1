package com.example.group1.ss.dao;

import com.example.group1.ss.model.Mark;
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

    public Mark get (int id) {
        return jdbcTemplate.queryForObject (sql: "SELECT * FROM mark WHERE id = ?", this:mapMark, id);
    }

    private Mark mapMark (ResultSet rs, int i) throw SQLException {
        Mark mark = new Mark (
                rs.getInt(columnLabel: "id"),
        rs.getString(columnLabel: "name"),
        rs.getInt(columnLabel: "value"),
        );

        return mark;
    }
}