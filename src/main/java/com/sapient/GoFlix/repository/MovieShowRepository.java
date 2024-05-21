package com.sapient.GoFlix.repository;

import com.sapient.GoFlix.model.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieShowRepository  extends JpaRepository<MovieShow, Long> {
    List<MovieShow> findByMovieId(int movieId);

    @Query("SELECT ms FROM MovieShow ms WHERE ms.movieId = :movieId AND ms.theater.city.id = :cityId AND :date BETWEEN ms.startDate AND ms.endDate")
    List<MovieShow> findByMovieIdAndCityIdAndDate(int movieId, int cityId, String date);

}
