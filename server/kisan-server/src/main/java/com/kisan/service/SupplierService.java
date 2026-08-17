package com.kisan.service;

import com.kisan.dto.SupplierRequestDTO;
import com.kisan.dto.SupplierResponseDTO;
import com.kisan.mapper.SupplierMapper;
import com.kisan.model.Supplier;
import com.kisan.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierService(SupplierRepository supplierRepository , SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    public List<SupplierResponseDTO> getAllSuppliers() {
        List<Supplier> allSuplliers = supplierRepository.findAll();
        return supplierMapper.toListDto(allSuplliers);
    }

    public SupplierResponseDTO saveSupplier(SupplierRequestDTO supplierDto){
        Supplier supplier = supplierMapper.toEntity(supplierDto);
        Supplier savedSupplier =  supplierRepository.save(supplier);
        return supplierMapper.toDto(savedSupplier);
    }
}
