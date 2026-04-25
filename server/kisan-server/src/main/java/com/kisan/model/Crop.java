package com.kisan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String season;
    private String soilType;
    private String fertilizer;
    private String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    public String getSoilType() {
        return soilType;
    }

    public String getFertilizer() {
        return fertilizer;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public void setFertilizer(String fertilizer) {
        this.fertilizer = fertilizer;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}