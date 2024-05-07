package com.sapient.GoFlix.model;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class MovieShow {
    private int movieShowId;
    private int movieId;
    private String startTime;
    private String endTime;
    private String movieName;
    private int theaterId;
    private String theaterName;
    private int basePrice;
}
