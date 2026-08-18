package com.kisan.service;

import com.kisan.dto.TransporterRequestDTO;
import com.kisan.dto.TransporterResponseDTO;
import com.kisan.mapper.TransporterMapper;
import com.kisan.model.Transporter;
import com.kisan.repository.TransporterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransporterService {

    private final TransporterRepository transporterRepository;
    private final TransporterMapper transporterMapper;

    public TransporterService(TransporterRepository transporterRepository, TransporterMapper transporterMapper) {
        this.transporterRepository = transporterRepository;
        this.transporterMapper = transporterMapper;
    }

    public List<TransporterResponseDTO> getAllTransporters() {
        List<Transporter> allTransporters = transporterRepository.findAll();
        return transporterMapper.toDtoList(allTransporters);
    }

    public TransporterResponseDTO saveTransporter(TransporterRequestDTO transporter) {
        return transporterMapper.toDto(transporterRepository.save(transporterMapper.toEntity(transporter)));
    }
}
