package com.sapient.GoFlix.jdbc.dao;

import com.sapient.GoFlix.model.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TheaterDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Theater> listTheatersByCity(int cityId){
        String sql = "SELECT * FROM Theater WHERE THEATER_ID = " + cityId;

        return jdbcTemplate.query(sql, new RowMapper<Theater>() {
            @Override
            public Theater mapRow(ResultSet rs, int rowNum) throws SQLException {
                Theater theater = new Theater();
                theater.setId(rs.getInt("Theater_ID"));
                theater.setName(rs.getString("Name"));
                theater.setCityId(rs.getInt("City_ID"));
                theater.setScreenCount(rs.getInt("Screen_Count"));

                return theater;
            }
        });
    }

    public List<Theater> listTheatersByMovie(int cityId, int movieId){
        String sql = "SELECT * FROM Theater";

        return jdbcTemplate.query(sql, new RowMapper<Theater>() {
            @Override
            public Theater mapRow(ResultSet rs, int rowNum) throws SQLException {
                Theater theater = new Theater();
                theater.setId(rs.getInt("Theater_ID"));
                theater.setName(rs.getString("Name"));
                theater.setCityId(rs.getInt("City_ID"));
                theater.setScreenCount(rs.getInt("Screen_Count"));

                return theater;
            }
        });
    }
}
