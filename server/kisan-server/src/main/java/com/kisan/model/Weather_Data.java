package com.kisan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

@Entity
public class Weather_Data {

    @Id
    private Long id;

    private String location;

    private Long temperature;

    private Long humidity;

    private String forecast;

    private String timestamp;
}

