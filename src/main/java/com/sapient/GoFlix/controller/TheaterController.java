package com.sapient.GoFlix.controller;

import com.sapient.GoFlix.jdbc.dao.TheaterDAO;
import com.sapient.GoFlix.model.Seat;
import com.sapient.GoFlix.model.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/theaterservice")
public class TheaterController {
    @Autowired
    TheaterDAO theaterDAO;

    @CrossOrigin(origins = "*")
    @PostMapping("listTheaterByCity")
    public ResponseEntity<List<Theater>> listTheaterByCity(int cityId) {
        return new ResponseEntity<>(theaterDAO.listTheatersByCity(cityId), HttpStatus.OK);
    }

    public ResponseEntity<String> createTheater(String theaterName, int countryId, int stateId, int cityId, int screenCount) {
        return null;
    }

    public ResponseEntity<String> createScreen(int theaterId, int screenNumber, int screenSizeFt, int rowCount, int columnCount) {
        return null;
    }

    public ResponseEntity<String> createSeatLayout(Seat[] seatArray) {
        return null;
    }

    public ResponseEntity<String> getScreenLayout(int screenId) {
        return null;
    }
}
