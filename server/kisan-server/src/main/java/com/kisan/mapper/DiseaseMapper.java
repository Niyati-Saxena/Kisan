package com.kisan.mapper;

import com.kisan.dto.DiseaseRequestDTO;
import com.kisan.dto.DiseaseResponseDTO;
import com.kisan.model.Disease;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiseaseMapper {

    public Disease toEntity(DiseaseRequestDTO request) {
        Disease disease = new Disease();

        disease.setName(request.name());
        disease.setSymptoms(request.symptoms());
        disease.setTreatment(request.treatment());

        return disease;
    }

    public DiseaseResponseDTO toDto(Disease request) {
        return new DiseaseResponseDTO(request.getName(), request.getTreatment(), request.getSymptoms());
    }

    public List<DiseaseResponseDTO> toDtoList(List<Disease> request) {
        return request.stream().map(this::toDto).toList();
    }
}
