package com.kisan.controller;

import com.kisan.dto.CropRequestDTO;
import com.kisan.dto.CropResponseDTO;
import com.kisan.model.Crop;
import com.kisan.service.CropService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @GetMapping
    public ResponseEntity<List<CropResponseDTO>> getAllCrops() {
        List<CropResponseDTO> allCrops = cropService.getAllCrops();
        return ResponseEntity.ok(allCrops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CropResponseDTO> getCropById(@PathVariable Long id) {
        return cropService.getCropById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Crop> addCrop(@RequestBody @Valid CropRequestDTO request) {
        Crop newCrop = cropService.createCrop(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCrop);
    }
}