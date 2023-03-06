package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Sequence {
    @Id
    @SequenceGenerator(
            name = "sequence_sequence",
            sequenceName = "sequence_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_sequence"
    )
    private Long sequenceID;
    private Integer sequence;
    private Boolean isDone;
    @Enumerated(EnumType.STRING)
    private sequenceTypeEnum sequenceTypeEnum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workflowID", insertable = false, updatable = false)
    private Workflow workflow;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaireID", insertable = false, updatable = false)
    private Questionnaire questionnaire;

    @OneToMany(mappedBy = "sequence", cascade = CascadeType.ALL)
    private List<Answer> answer;

    @OneToOne(mappedBy = "sequence", cascade= CascadeType.ALL)
    private QuestionnaireSequence questionnaireSequence;

    @OneToOne(mappedBy = "sequence", cascade= CascadeType.ALL)
    private ApprovalSequence approvalSequence;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userTypeID", insertable = false, updatable = false)
    private UserType userType;

    @OneToMany(mappedBy = "sequenceForUserWorkflow", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserWorkflowSequence> userWorkflowSequences;

    public Sequence(Long sequenceID, Integer sequence, Boolean isDone,
            sequenceTypeEnum sequenceTypeEnum) {
        this.sequenceID = sequenceID;
        this.sequence = sequence;
        this.isDone = isDone;
        this.sequenceTypeEnum = sequenceTypeEnum;
    }

    public Sequence() {

    }


    public Long getSequenceID() {
        return sequenceID;
    }

    public void setSequenceID(Long sequenceID) {
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