package com.kisan.mapper;

import com.kisan.dto.TransporterRequestDTO;
import com.kisan.dto.TransporterResponseDTO;
import com.kisan.model.Transporter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransporterMapper {
    public Transporter toEntity(TransporterRequestDTO requestDTO) {
        Transporter transporter = new Transporter();

        transporter.setName(requestDTO.name());
        transporter.setVehicleType(requestDTO.vehicleType());
        transporter.setRoute(requestDTO.route());

        return transporter;
    }

    public TransporterResponseDTO toDto(Transporter transporter) {
        return new TransporterResponseDTO(transporter.getName() , transporter.getVehicleType(), transporter.getRoute());
    }

    public List<TransporterResponseDTO> toDtoList(List<Transporter> request) {
        return request.stream().map(this::toDto).toList();
    }
}
