package com.kisan.service;

import com.kisan.model.Skill;
import com.kisan.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

   private SkillRepository skillRepository;

   public SkillService(SkillRepository skillRepository) {
       this.skillRepository = skillRepository;
   }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }
}
