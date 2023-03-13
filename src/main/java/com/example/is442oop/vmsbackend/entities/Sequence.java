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

    public enum sequenceTypeEnum {
        APPROVAL,
        QUESTIONNAIRE

    }
    @Enumerated(EnumType.STRING)
    private Sequence.sequenceTypeEnum sequenceTypeEnum;

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

    public Sequence(Integer sequence,
                    sequenceTypeEnum sequenceTypeEnum) {
        this.sequence = sequence;
        this.sequenceTypeEnum = sequenceTypeEnum;
    }
    public Sequence(Long sequenceID, Integer sequence, Boolean isDone, sequenceTypeEnum sequenceTypeEnum, Questionnaire questionnaire, UserType userType, Workflow workflow){
        this.sequenceID = sequenceID;
        this.sequence = sequence;
        this.isDone = isDone;
        this.sequenceTypeEnum = sequenceTypeEnum;
        this.questionnaire = questionnaire;
        this.userType = userType;
        this.workflow = workflow;
    }
    public Sequence(Integer sequence, Boolean isDone, sequenceTypeEnum sequenceTypeEnum, Questionnaire questionnaire, UserType userType, Workflow workflow){
        this.sequence = sequence;
        this.isDone = isDone;
        this.sequenceTypeEnum = sequenceTypeEnum;
        this.questionnaire = questionnaire;
        this.userType = userType;
        this.workflow = workflow;
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

    public void setQuestionnaireSequence(QuestionnaireSequence questionnaireSequence) { this.questionnaireSequence = questionnaireSequence; }
    public QuestionnaireSequence getQuestionnaireSequence() {
        return questionnaireSequence;
    }
    public void setApprovalSequence(ApprovalSequence approvalSequence) {
        this.approvalSequence = approvalSequence;
    }

    public void setQuestionnaire(Questionnaire questionnaire) { this.questionnaire = questionnaire; }

    public void setWorkflow(Workflow workflow) { this.workflow = workflow; }
    public void setUserType(UserType userType) { this.userType = userType; }
}

