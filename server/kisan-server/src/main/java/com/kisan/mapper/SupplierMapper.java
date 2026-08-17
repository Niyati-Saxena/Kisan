package com.kisan.mapper;

import com.kisan.dto.SupplierRequestDTO;
import com.kisan.dto.SupplierResponseDTO;
import com.kisan.model.Supplier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SupplierMapper {

    // dto -> entity
    public Supplier toEntity(SupplierRequestDTO request) {
        Supplier supplier = new Supplier();

        supplier.setLocation(request.location());
        supplier.setName(request.name());
        supplier.setSpeciality(request.speciality());

        return supplier;
    }


    // entity -> dto
    public SupplierResponseDTO toDto(Supplier request) {
        return new SupplierResponseDTO(request.getName(), request.getLocation());
    }

    // entity - dtoList
    public List<SupplierResponseDTO> toListDto (List<Supplier> request) {
        return request.stream().map(this::toDto).toList();
    }

}
