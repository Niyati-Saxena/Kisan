package com.kisan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String symptoms;
    private String treatment;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
