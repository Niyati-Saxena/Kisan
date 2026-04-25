package com.kisan.controller;

import com.kisan.model.Disease;
import com.kisan.model.Skill;
import com.kisan.repository.DiseaseRepository;
import com.kisan.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Disease addDisease(@RequestBody Disease disease) {
        return diseaseRepo.save(disease);
    }

    @PostMapping("/skills")
    public Skill addSkill(@RequestBody Skill skill) {
        return skillRepo.save(skill);
    }
}