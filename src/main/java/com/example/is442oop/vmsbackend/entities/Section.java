package com.example.is442oop.vmsbackend.entities;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Section {
    @Id
    private Integer stringID;
    private String section;
    private String sectionDescription;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionnaireID", insertable = false, updatable = false)
    private Questionnaire questionnaire; 
    @OneToMany(mappedBy="section", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Question> question;



    public Section(Integer stringID, String section, String sectionDescription) {
        this.stringID = stringID;
        this.section = section;
        this.sectionDescription = sectionDescription;
    }

    public Section() {

    }

    public Integer getStringID() {
        return stringID;
    }

    public void setStringID(Integer stringID) {
        this.stringID = stringID;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

}
