package com.kisan.repository;

import com.kisan.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {
    List<Crop> findBySeason(String season);
}
