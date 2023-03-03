package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.*;


@Entity
public class Questionnaire {
    @Id 
    private Long questionnaireID;
    private String name;
    @OneToMany(mappedBy="questionnaire", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Question> questions;

    @OneToMany(mappedBy="questionnaire", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <QuestionnaireSequence> sequenceQuestionnaires;

    @OneToMany(mappedBy="questionnaireToApprove", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set<ApprovalSequence> sequenceApprovals;

    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="formID", insertable=false, updatable = false)
    private Form form;
    
    public Questionnaire(Long questionnaireID, String name) {
        this.questionnaireID = questionnaireID;
        this.name = name;
    }

    public Questionnaire(){

    }


    public Long getQuestionnaireID() {
        return questionnaireID;
    }
    public void setQuestionnaireID(Long questionnaireID) {
        this.questionnaireID = questionnaireID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } 
}
