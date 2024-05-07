package com.sapient.GoFlix.controller;

import com.sapient.GoFlix.jdbc.dao.TheaterDAO;
import com.sapient.GoFlix.model.MovieShow;
import com.sapient.GoFlix.model.Seat;
import com.sapient.GoFlix.model.Theater;
import com.sapient.GoFlix.services.TheaterService;
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
public class TheaterController extends TheaterService {
    @Autowired
    TheaterDAO theaterDAO;

    /**
     * @param cityId
     * @return
     */
    @Override
    @CrossOrigin(origins = "*")
    @PostMapping("listTheaterByCity")
    public ResponseEntity<List<Theater>> listTheaterByCity(int cityId) {
        return new ResponseEntity<>(theaterDAO.listTheatersByCity(cityId), HttpStatus.OK);
    }

    /**
     * @param theaterName
     * @param countryId
     * @param stateId
     * @param cityId
     * @param screenCount
     * @return
     */
    @Override
    public ResponseEntity<String> createTheater(String theaterName, int countryId, int stateId, int cityId, int screenCount) {
        return null;
    }

    /**
     * @param theaterId
     * @param screenNumber
     * @param screenSizeFt
     * @param rowCount
     * @param columnCount
     * @return
     */
    @Override
    public ResponseEntity<String> createScreen(int theaterId, int screenNumber, int screenSizeFt, int rowCount, int columnCount) {
        return null;
    }

    /**
     * @param seatArray
     * @return
     */
    @Override
    public ResponseEntity<String> createSeatLayout(Seat[] seatArray) {
        return null;
    }

    /**
     * @param screenId
     * @return
     */
    @Override
    public ResponseEntity<String> getScreenLayout(int screenId) {
        return null;
    }
}
