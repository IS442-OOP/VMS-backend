package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sequence")
public class Sequence {
    @Id
    private Integer sequenceID;
    private Integer sequence;
    private Boolean isDone;
    @Enumerated(EnumType.STRING)
    private sequenceTypeEnum sequenceTypeEnum;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "workflowID", insertable = false, updatable = false)
    private Workflow workflow;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionnaireID", insertable = false, updatable = false)
    private Questionnaire questionnaire;

    @OneToMany(mappedBy = "sequence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Answer> answer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userTypeID", insertable = false, updatable = false)
    private UserType userType;

    public Sequence(Integer sequenceID, Integer sequence, Boolean isDone,
            sequenceTypeEnum sequenceTypeEnum) {
        this.sequenceID = sequenceID;
        this.sequence = sequence;
        this.isDone = isDone;
        this.sequenceTypeEnum = sequenceTypeEnum;
    }

    public Sequence() {

    }


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

    public sequenceTypeEnum getSequenceTypeEnum() {
        return sequenceTypeEnum;
    }

    public void setSequenceTypeEnum(sequenceTypeEnum sequenceTypeEnum) {
        this.sequenceTypeEnum = sequenceTypeEnum;
    }


}

enum sequenceTypeEnum {
    APPROVAL,
    QUESTIONAIRE

}