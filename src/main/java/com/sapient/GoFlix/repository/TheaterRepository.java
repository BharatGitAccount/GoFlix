package com.sapient.GoFlix.repository;

import com.sapient.GoFlix.model.MovieShow;
import com.sapient.GoFlix.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

}
