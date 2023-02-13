package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.*;


@Entity
public class Questionnaire {
    @Id 
    private Integer questionnaireID;
    private String name;
    @OneToMany(mappedBy="questionnaire", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Sequence> sequence;

    @OneToMany(mappedBy="section", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Section> section;

    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="formID", insertable=false, updatable = false)
    private Form form;
    
    public Questionnaire(Integer questionnaireID, String name) {
        this.questionnaireID = questionnaireID;
        this.name = name;
    }

    public Questionnaire(){

    }


    public Integer getQuestionnaireID() {
        return questionnaireID;
    }
    public void setQuestionnaireID(Integer questionnaireID) {
        this.questionnaireID = questionnaireID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } 
}
