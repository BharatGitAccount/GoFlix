package com.sapient.GoFlix.services;

import com.sapient.GoFlix.model.Seat;
import com.sapient.GoFlix.model.Theater;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class TheaterService {
    public abstract ResponseEntity<List<Theater>> listTheaterByCity(int cityId);
    public abstract ResponseEntity<String> createTheater(String theaterName, int countryId, int stateId, int cityId, int screenCount);
    public abstract ResponseEntity<String> createScreen(int theaterId, int screenNumber, int screenSizeFt, int rowCount, int columnCount);
    public abstract ResponseEntity<String> createSeatLayout(Seat[] seatArray);
    public abstract ResponseEntity<String> getScreenLayout(int screenId);
}
