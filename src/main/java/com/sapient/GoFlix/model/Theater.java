package com.sapient.GoFlix.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Theater {
    int id;
    String name;
    int cityId;
    int screenCount;

}
