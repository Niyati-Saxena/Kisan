package com.kisan.controller;

import com.kisan.model.Transporter;
import com.kisan.service.TransporterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transporters")
@CrossOrigin(origins = "http://localhost:3000")
public class TransporterController {

    private final TransporterService transporterService;

    public TransporterController(TransporterService transporterService) {
        this.transporterService = transporterService;
    }

    @GetMapping
    public ResponseEntity<List<Transporter>> getAllTransporters() {
        List<Transporter> allTransporters = transporterService.getAllTransporters();
        return ResponseEntity.ok(allTransporters);
    }

    @PostMapping
    public ResponseEntity<Transporter> addTransporter(@RequestBody Transporter transporter) {
        Transporter newTransporter = transporterService.saveTransporter(transporter);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransporter);
    }
}
