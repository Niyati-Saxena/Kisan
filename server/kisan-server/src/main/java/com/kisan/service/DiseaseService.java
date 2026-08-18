package com.kisan.service;

import com.kisan.dto.DiseaseRequestDTO;
import com.kisan.dto.DiseaseResponseDTO;
import com.kisan.mapper.DiseaseMapper;
import com.kisan.model.Disease;
import com.kisan.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {

   private final DiseaseRepository diseaseRepository;
   private final DiseaseMapper diseaseMapper;

   public DiseaseService(DiseaseRepository diseaseRepository, DiseaseMapper diseaseMapper) {
       this.diseaseRepository = diseaseRepository;
       this.diseaseMapper = diseaseMapper;
   }

    public List<DiseaseResponseDTO> getAllDiseases(){
        List<Disease> allDiseases = diseaseRepository.findAll();
        return diseaseMapper.toDtoList(allDiseases);
    }

    public DiseaseResponseDTO saveDisease(DiseaseRequestDTO request) {
        Disease disease = diseaseRepository.save(diseaseMapper.toEntity(request));
        return diseaseMapper.toDto(disease);
    }

}
