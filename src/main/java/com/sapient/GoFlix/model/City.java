package com.sapient.GoFlix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int cityId;
    String name;
    int stateId;

//    @OneToMany(mappedBy = "city")
//    private Set<Theater> theaters;
}
