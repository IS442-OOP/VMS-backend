package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    private Integer answerID;
    private String answer; 
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="questionID", insertable=false, updatable = false)
    private Question question;
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY, optional = true)
    @JoinColumn(name="userWorkflowID", insertable=false, updatable = false, nullable = true)
    private UserWorkflow userWorkflow;
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="sequenceID", insertable=false, updatable = false)
    private Sequence sequence;


    public Answer(Integer answerID, String answer) {
        this.answerID = answerID;
        this.answer = answer;
    }

    public Answer(){

    }

    public Integer getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Integer answerID) {
        this.answerID = answerID;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
