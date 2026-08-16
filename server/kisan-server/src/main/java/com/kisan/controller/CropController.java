package com.kisan.controller;

import com.kisan.model.Crop;
import com.kisan.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crop> getCropById(@PathVariable Long id) {
        return cropService.getCropById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Crop> addCrop(@RequestBody Crop crop) {
        Crop newCrop = cropService.createCrop(crop);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCrop);
    }
}