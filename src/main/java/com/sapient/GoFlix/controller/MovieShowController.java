package com.sapient.GoFlix.controller;

import com.sapient.GoFlix.model.MovieShow;
import com.sapient.GoFlix.repository.MovieShowRepository;
import com.sapient.GoFlix.services.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movieshowservice")
public class MovieShowController{

    @Autowired
    MovieShowService movieShowService;

    @CrossOrigin(origins = "*")
    @PostMapping("listTheaterByShow")
    public List<MovieShow> listTheaterByShow(int cityId, int movieId, String date) {
        return movieShowService.findByMovieIdAndCityIdAndDate(cityId, movieId, date);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("createMovieShow")
    public ResponseEntity<String> createMovieShow(String startDate, String endDate, String startTime, String endTime, String movieName, int movieId,
                                                  int theaterId, String theaterName, int basePrice, int screenId) {
        return movieShowService.createMovieShow(startDate, endDate, startTime, endTime, movieName, movieId, theaterId, theaterName, basePrice, screenId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("updateMovieShow")
    public ResponseEntity<String> updateMovieShow(long movieShowId, String startDate, String endDate, String startTime, String endTime, String movieName, int movieId,
                                                  int theaterId, String theaterName, int basePrice, int screenId) {
        return movieShowService.updateMovieShow(movieShowId, startDate, endDate, startTime, endTime, movieName, movieId, theaterId, theaterName, basePrice, screenId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("deleteMovieShow")
    public ResponseEntity<String> deleteMovieShow(long movieShowId) {
        return movieShowService.deleteMovieShow(movieShowId);
    }
}
