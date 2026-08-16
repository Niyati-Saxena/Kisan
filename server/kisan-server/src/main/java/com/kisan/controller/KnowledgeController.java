package com.kisan.controller;

import com.kisan.model.Disease;
import com.kisan.model.Skill;
import com.kisan.repository.DiseaseRepository;
import com.kisan.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/knowledge")
@CrossOrigin(origins = "http://localhost:3000")
public class KnowledgeController {

    @Autowired
    private DiseaseRepository diseaseRepo;

    @Autowired
    private SkillRepository skillRepo;

    @GetMapping("/diseases")
    public List<Disease> getDiseases() {
        return diseaseRepo.findAll();
    }

    @GetMapping("/skills")
    public List<Skill> getSkills() {
        return skillRepo.findAll();
    }

    @PostMapping("/diseases")
    public ResponseEntity<Disease> addDisease(@RequestBody Disease disease) {
        Disease newDisease = diseaseRepo.save(disease);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDisease);
    }

    @PostMapping("/skills")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
        Skill newSkill = skillRepo.save(skill);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSkill);
    }
}