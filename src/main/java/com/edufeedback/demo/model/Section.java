package com.edufeedback.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"subject"})
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sectionName;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Section() {}

    public Section(String sectionName) {
        this.sectionName = sectionName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }
    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }
}