package com.sapient.GoFlix.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "Theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int theaterId;
    String name;
    int screenCount;
    String location;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

//    @OneToMany(mappedBy = "theater")
//    private Set<MovieShow> movieShows;
}
