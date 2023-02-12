package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="sequence")
public class Sequence {
    @Id 
    private Integer sequenceID;
    private Integer sequence;
    private Boolean isDone;
    private String sequenceType;


    public Sequence(Integer sequenceID, Integer sequence, Boolean isDone, String sequenceType) {
        this.sequenceID = sequenceID;
        this.sequence = sequence;
        this.isDone = isDone;
        this.sequenceType = sequenceType;
    }

    public Sequence(){
        
    }


    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="workflowID", insertable=false, updatable = false)
    private Workflow workflow;

    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="questionnaireID", insertable=false, updatable = false)
    private Questionnaire questionnaire;

    @OneToMany(mappedBy="sequence", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List <Answer> answer;


    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="userTypeID", insertable=false, updatable = false)
    private UserType userType;
    


    public Integer getSequenceID() {
        return sequenceID;
    }


    public void setSequenceID(Integer sequenceID) {
        this.sequenceID = sequenceID;
    }


    public Integer getSequence() {
        return sequence;
    }


    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }


    public Boolean getIsDone() {
        return isDone;
    }


    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }


    public String getSequenceType() {
        return sequenceType;
    }


    public void setSequenceType(String sequenceType) {
        this.sequenceType = sequenceType;
    }


}
