package com.kisan.controller;

import com.kisan.dto.SupplierRequestDTO;
import com.kisan.dto.SupplierResponseDTO;
import com.kisan.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "http://localhost:3000")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponseDTO>> getAllSuppliers() {
        List<SupplierResponseDTO> allSuppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(allSuppliers);
    }

    @PostMapping
    public ResponseEntity<SupplierResponseDTO> addSupplier(@RequestBody @Valid SupplierRequestDTO request) {
        SupplierResponseDTO newSupplier = supplierService.saveSupplier(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSupplier);
    }
}