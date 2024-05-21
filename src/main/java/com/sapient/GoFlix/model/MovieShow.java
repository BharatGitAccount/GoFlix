package com.sapient.GoFlix.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name = "Movie_Show")
@ToString
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieShowId;
    private int movieId;
    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;
    private int screenId;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String movieName;

    private int basePrice;
    private int isActivee;
}
