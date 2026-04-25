package com.kisan.repository;

import com.kisan.model.Weather_Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Weather_DataRepository extends JpaRepository<Weather_Data, Long> {

    
}
