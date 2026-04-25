package com.kisan.controller;

import com.kisan.model.Transporter;
import com.kisan.repository.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transporters")
@CrossOrigin(origins = "http://localhost:3000")
public class TransporterController {

    @Autowired
    private TransporterRepository repo;

    @GetMapping
    public List<Transporter> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Transporter addTransporter(@RequestBody Transporter transporter) {
        return repo.save(transporter);
    }
}
