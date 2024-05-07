package com.sapient.GoFlix.jdbc.dao;

import com.sapient.GoFlix.model.MovieShow;
import com.sapient.GoFlix.model.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MovieShowDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String createMovieShow(String startDate, String endDate, String startTime, String endTime, String movieName, int movieId,
                                  int theaterId, String theaterName, int basePrice, int screenId){
        return null;
    }

    public String modifyMovieShow(String startDate, String endDate, String startTime, String endTime, String movieName, int movieId,
                                  int theaterId, String theaterName, int basePrice, int screenId){
        String sql = "INSERT INTO Movie_Show VALUES ("+movieId+", "+theaterId+", "+screenId+", "+startDate+", "+startTime+", "+endDate+", "+endTime+", "+basePrice+")";


        return null;
    }

    public String deleteMovieShow(int movieShowId){
        String sql = "UPDATE Movie_Show SET Is_Active = 0 WHERE Movie_Show_ID = " + movieShowId;

        try{
            return (jdbcTemplate.update(sql) == 1)? "True":"False";
        } catch (Exception e){
            return e.getMessage();
        }
    }

    public List<MovieShow> listShowsByMovie(int cityId, int movieId, String date){
        String sql = "SELECT distinct s.Movie_Show_ID, m.Movie_ID, s.Start_Time, s.End_Time ,m.Name as Movie, t.Theater_ID, t.Name, s.Base_Price FROM Movie_Show s INNER JOIN Theater t ON t.Theater_ID = s.Theater_ID " +
                " INNER JOIN Movie m ON s.movie_id = m.movie_id INNER JOIN Screen scr ON scr.Theater_ID = t.Theater_ID WHERE m.Movie_ID = " + movieId +
                " AND t.City_ID = " + cityId + " AND ('" + date + "' BETWEEN s.START_DATE AND s.END_DATE) AND s.Is_Active = 1";

        return jdbcTemplate.query(sql, new RowMapper<MovieShow>() {
            @Override
            public MovieShow mapRow(ResultSet rs, int rowNum) throws SQLException {
                MovieShow show = new MovieShow(rs.getInt("Movie_Show_ID"),
                        rs.getInt("Movie_ID"),
                        rs.getString("Start_Time"),
                        rs.getString("End_Time"),
                        rs.getString("Movie"),
                        rs.getInt("Theater_ID"),
                        rs.getString("Name"),
                        rs.getInt("Base_Price")
                );

                return show;
            }
        });
    }
}
