package com.kisan.service;

import com.kisan.model.Transporter;
import com.kisan.repository.TransporterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransporterService {

    private final TransporterRepository transporterRepository;

    public TransporterService(TransporterRepository transporterRepository) {
        this.transporterRepository = transporterRepository;
    }

    public List<Transporter> getAllTransporters() {
        return transporterRepository.findAll();
    }

    public Transporter saveTransporter(Transporter transporter) {
        return transporterRepository.save(transporter);
    }
}
