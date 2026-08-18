package com.kisan.mapper;

import com.kisan.dto.CropRequestDTO;
import com.kisan.dto.CropResponseDTO;
import com.kisan.model.Crop;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CropMapper {

    public Crop toEntity(CropRequestDTO request) {
        Crop crop = new Crop();

        crop.setDescription(request.description());
        crop.setFertilizer(request.fertilizer());
        crop.setName(request.name());
        crop.setSeason(request.season());
        crop.setSoilType(request.soilType());

        return crop;
    }

    public CropResponseDTO toDto(Crop crop) {
        return new CropResponseDTO(crop.getName(), crop.getSeason(), crop.getSoilType());
    }

    public List<CropResponseDTO> toDtoList(List<Crop> crop) {
        return crop.stream().map(this::toDto).toList();
    }
}
