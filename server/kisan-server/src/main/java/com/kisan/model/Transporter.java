package com.kisan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transporter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String vehicleType;
    private String route;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getRoute() {
        return route;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
