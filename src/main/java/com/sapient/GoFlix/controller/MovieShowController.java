package com.sapient.GoFlix.controller;

import com.sapient.GoFlix.jdbc.dao.MovieShowDAO;
import com.sapient.GoFlix.model.MovieShow;
import com.sapient.GoFlix.services.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movieshowservice")
public class MovieShowController extends MovieShowService {
    @Autowired
    MovieShowDAO movieShowDAO;

    /**
     * @param cityId
     * @return
     */
    @Override
    @CrossOrigin(origins = "*")
    @PostMapping("listTheaterByShow")
    public ResponseEntity<List<MovieShow>> listTheaterByShow(int cityId, int movieId, String date) {
        return new ResponseEntity<>(movieShowDAO.listShowsByMovie(cityId, movieId, date), HttpStatus.OK);
    }

    /**
     *
     * @param startDate
     * @param endDate
     * @param startTime
     * @param endTime
     * @param movieName
     * @param movieId
     * @param theaterId
     * @param theaterName
     * @param basePrice
     * @param screenId
     * @return
     */
    @Override
    @CrossOrigin(origins = "*")
    @PostMapping("createMovieShow")
    public ResponseEntity<String> createMovieShow(String startDate, String endDate, String startTime, String endTime, String movieName, int movieId,
                                                  int theaterId, String theaterName, int basePrice, int screenId) {
        try{
            return new ResponseEntity<>(movieShowDAO.createMovieShow(startDate, endDate, startTime, endTime, movieName, movieId, theaterId, theaterName, basePrice, screenId),
                    HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param movieShowId
     * @return
     */
    @Override
    @CrossOrigin(origins = "*")
    @PostMapping("deleteMovieShow")
    public ResponseEntity<String> deleteMovieShow(int movieShowId) {
        try{
            return new ResponseEntity<>(movieShowDAO.deleteMovieShow(movieShowId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
