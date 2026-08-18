package com.kisan.mapper;

import com.kisan.dto.SkillRequestDTO;
import com.kisan.dto.SkillResponseDTO;
import com.kisan.model.Skill;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkillMapper {

    public SkillResponseDTO toDto(Skill request) {
        return new SkillResponseDTO(request.getTitle() , request.getDescription());
    }

    public List<SkillResponseDTO> toDtoList(List<Skill> request) {
        return request.stream().map(this::toDto).toList();
    }

    public Skill toEntity(SkillRequestDTO request) {
        Skill skill = new Skill();

        skill.setDescription(request.description());
        skill.setTitle(request.title());

        return skill;
    }
}
