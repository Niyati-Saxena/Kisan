package com.kisan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class News {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String summary;
    private String link;
    private String date;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getLink() {
        return link;
    }

    public String getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDate(String date) {
        this.date = date;
    }
}