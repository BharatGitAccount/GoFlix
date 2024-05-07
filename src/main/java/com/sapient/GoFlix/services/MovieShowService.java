package com.sapient.GoFlix.services;

import com.sapient.GoFlix.model.MovieShow;
import com.sapient.GoFlix.model.Seat;
import com.sapient.GoFlix.model.Theater;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class MovieShowService {
    public abstract ResponseEntity<List<MovieShow>> listTheaterByShow(int cityId, int movieId, String date);

    public abstract ResponseEntity<String> createMovieShow(String startDate, String endDate, String startTime, String endTime, String movieName, int movieId,
                                                           int theaterId, String theaterName, int basePrice, int screenId);

    public abstract ResponseEntity<String> deleteMovieShow(int movieShowId);
}
