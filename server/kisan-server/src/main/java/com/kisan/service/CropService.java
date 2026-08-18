package com.kisan.service;

import com.kisan.dto.CropRequestDTO;
import com.kisan.dto.CropResponseDTO;
import com.kisan.mapper.CropMapper;
import com.kisan.model.Crop;
import com.kisan.repository.CropRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    private final CropRepository cropRepository;
    private final CropMapper cropMapper;

    public CropService(CropRepository cropRepository, CropMapper cropMapper) {
        this.cropRepository = cropRepository;
        this.cropMapper = cropMapper;
    }

    public List<CropResponseDTO> getAllCrops() {
        List<Crop> allCrops = cropRepository.findAll();
        return cropMapper.toDtoList(allCrops);
    }

    public Optional<CropResponseDTO> getCropById(Long id) {
        return cropRepository.findById(id).map(cropMapper::toDto);
    }

    public Crop createCrop(CropRequestDTO request) {
        Crop crop = cropMapper.toEntity(request);
        return cropRepository.save(crop);
    }


}
