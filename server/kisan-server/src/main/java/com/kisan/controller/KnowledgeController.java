package com.kisan.controller;

import com.kisan.model.Disease;
import com.kisan.model.Skill;
import com.kisan.service.DiseaseService;
import com.kisan.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/knowledge")
@CrossOrigin(origins = "http://localhost:3000")
public class KnowledgeController {

    private DiseaseService diseaseService;
    private SkillService skillService;

    public KnowledgeController(DiseaseService diseaseService , SkillService skillService) {
        this.diseaseService = diseaseService;
        this.skillService = skillService;
    }

    @GetMapping("/diseases")
    public ResponseEntity<List<Disease>> getDiseases() {
        List<Disease> allDiseases = diseaseService.getAllDiseases();
        return ResponseEntity.status(HttpStatus.OK).body(allDiseases);
    }

    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getSkills() {
        List<Skill> allSkills = skillService.getAllSkills();
        return ResponseEntity.status(HttpStatus.OK).body(allSkills);
    }

    @PostMapping("/diseases")
    public ResponseEntity<Disease> addDisease(@RequestBody Disease disease) {
        Disease newDisease = diseaseService.saveDisease(disease);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDisease);
    }

    @PostMapping("/skills")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
        Skill newSkill = skillService.saveSkill(skill);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSkill);
    }
}