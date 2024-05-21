package com.sapient.GoFlix.services;

import com.sapient.GoFlix.model.MovieShow;
import com.sapient.GoFlix.model.Theater;
import com.sapient.GoFlix.repository.MovieShowRepository;
import com.sapient.GoFlix.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieShowService {
    @Autowired
    MovieShowRepository movieShowRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public List<MovieShow> findByMovieIdAndCityIdAndDate(int cityId, int movieId, String date) {
        return movieShowRepository.findByMovieIdAndCityIdAndDate(movieId, cityId, date);
    }

    public ResponseEntity<String> createMovieShow(String startDate, String endDate, String startTime, String endTime, String movieName, int movieId,
                                  int theaterId, String theaterName, int basePrice, int screenId) {
        Theater theater = theaterRepository.findById((long) theaterId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid theater ID"));

        MovieShow movieShow = new MovieShow();
        movieShow.setStartDate(startDate);
        movieShow.setEndDate(endDate);
        movieShow.setStartTime(startTime);
        movieShow.setEndTime(endTime);
        movieShow.setMovieName(movieName);
        movieShow.setMovieId(movieId);
        movieShow.setBasePrice(basePrice);
        movieShow.setScreenId(screenId);
        movieShow.setTheater(theater);

        movieShowRepository.save(movieShow);
        return ResponseEntity.ok("MovieShow created successfully");
    }

    public ResponseEntity<String> deleteMovieShow(Long movieShowId) {
        try {
            if (movieShowRepository.existsById(movieShowId)) {
                movieShowRepository.deleteById(movieShowId);
                return ResponseEntity.ok("MovieShow deleted successfully");
            } else {
                return ResponseEntity.status(404).body("MovieShow not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting MovieShow: " + e.getMessage());
        }
    }

    public ResponseEntity<String> updateMovieShow(long movieShowId, String startDate, String endDate, String startTime, String endTime, String movieName, int movieId,
                                                  int theaterId, String theaterName, int basePrice, int screenId) {
        try {
            Optional<MovieShow> optionalMovieShow = movieShowRepository.findById(movieShowId);
            if (optionalMovieShow.isPresent()) {

                MovieShow movieShow = optionalMovieShow.get();
                System.out.println(movieShow);

                movieShow.setMovieName(movieName);
                movieShow.setStartDate(startDate);
                movieShow.setEndDate(endDate);
                movieShow.setStartTime(startTime);
                movieShow.setEndTime(endTime);
                movieShow.setBasePrice(basePrice);
                movieShow.setScreenId(screenId);

                // Update theater if necessary
                if (movieShow.getTheater() != null) {
                    Theater theater = theaterRepository.findById((long)movieShow.getTheater().getTheaterId())
                            .orElseThrow(() -> new IllegalArgumentException("Invalid theater ID"));
                    theater.setName(theaterName);
                    movieShow.setTheater(theater);
                }

                movieShowRepository.save(movieShow);
                return ResponseEntity.ok("MovieShow updated successfully");
            } else {
                return ResponseEntity.status(404).body("MovieShow not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating MovieShow: " + e.getMessage());
        }
    }
}
