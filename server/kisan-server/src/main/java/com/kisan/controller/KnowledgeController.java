package com.kisan.controller;

import com.kisan.dto.DiseaseRequestDTO;
import com.kisan.dto.DiseaseResponseDTO;
import com.kisan.dto.SkillRequestDTO;
import com.kisan.dto.SkillResponseDTO;
import com.kisan.service.DiseaseService;
import com.kisan.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/knowledge")
@CrossOrigin(origins = "http://localhost:3000")
public class KnowledgeController {

    private final DiseaseService diseaseService;
    private final SkillService skillService;

    public KnowledgeController(DiseaseService diseaseService , SkillService skillService) {
        this.diseaseService = diseaseService;
        this.skillService = skillService;
    }

    @GetMapping("/diseases")
    public ResponseEntity<List<DiseaseResponseDTO>> getDiseases() {
        List<DiseaseResponseDTO> allDiseases = diseaseService.getAllDiseases();
        return ResponseEntity.ok(allDiseases);
    }

    @GetMapping("/skills")
    public ResponseEntity<List<SkillResponseDTO>> getSkills() {
        List<SkillResponseDTO> allSkills = skillService.getAllSkills();
        return ResponseEntity.ok(allSkills);
    }

    @PostMapping("/diseases")
    public ResponseEntity<DiseaseResponseDTO> addDisease(@RequestBody @Valid DiseaseRequestDTO disease) {
        DiseaseResponseDTO newDisease = diseaseService.saveDisease(disease);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDisease);
    }

    @PostMapping("/skills")
    public ResponseEntity<SkillResponseDTO> addSkill(@RequestBody @Valid SkillRequestDTO skill) {
        SkillResponseDTO newSkill = skillService.saveSkill(skill);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSkill);
    }
}