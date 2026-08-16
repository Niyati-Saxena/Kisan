package com.kisan.controller;

import com.kisan.model.Supplier;
import com.kisan.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "http://localhost:3000")
public class SupplierController {

    @Autowired
    private SupplierRepository repo;

    @GetMapping
    public List<Supplier> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier newSupplier = repo.save(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSupplier);
    }
}