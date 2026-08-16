package com.kisan.service;

import com.kisan.model.Disease;
import com.kisan.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {

   private DiseaseRepository diseaseRepository;

   public DiseaseService(DiseaseRepository diseaseRepository) {
       this.diseaseRepository = diseaseRepository;
   }

    public List<Disease> getAllDiseases(){
        return diseaseRepository.findAll();
    }

    public Disease saveDisease(Disease disease) {
        return diseaseRepository.save(disease);
    }

}
