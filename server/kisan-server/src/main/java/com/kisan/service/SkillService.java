package com.kisan.service;

import com.kisan.dto.SkillRequestDTO;
import com.kisan.dto.SkillResponseDTO;
import com.kisan.mapper.SkillMapper;
import com.kisan.model.Skill;
import com.kisan.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

   private final SkillRepository skillRepository;
   private final SkillMapper skillMapper;

   public SkillService(SkillRepository skillRepository, SkillMapper skillMapper) {
       this.skillRepository = skillRepository;
       this.skillMapper = skillMapper;
   }

    public List<SkillResponseDTO> getAllSkills() {
       List<Skill> allSkills = skillRepository.findAll();
       return skillMapper.toDtoList(allSkills);
    }

    public SkillResponseDTO saveSkill(SkillRequestDTO request) {
       Skill skill = skillRepository.save(skillMapper.toEntity(request));
       return skillMapper.toDto(skill);

    }
}
