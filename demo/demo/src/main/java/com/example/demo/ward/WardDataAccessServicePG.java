package com.example.demo.ward;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.enterprise.inject.spi.Bean;
import java.util.List;

@Repository

public class WardDataAccessServicePG {

    private JdbcTemplate jdbcTemplate;

    public WardDataAccessServicePG (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Ward> selectAllWards() {
        String selectSql = """
                SELECT * FROM ward
                """;
        return jdbcTemplate.query(selectSql, new BeanPropertyRowMapper(Ward.class));
    }

    public int insertWard(Ward ward) {
        String insertSql = """
        INSERT INTO ward(ward_id, ward_name) VALUES(?, ?)
        """;
        int result = jdbcTemplate.update(insertSql, ward.getWardId(), ward.getWardName());
        return result;
    }

    public void deleteWard(Ward ward) {
        String deleteSql = """
                DELETE FROM ward WHERE ward_id = ?
                """;
        jdbcTemplate.update(deleteSql, ward.getWardId());
    }
}
