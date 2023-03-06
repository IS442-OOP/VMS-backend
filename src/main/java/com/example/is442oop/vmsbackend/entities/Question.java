package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.*;


@Entity
public class Question {
    @Id
    private Long questionID;
    private String question; 
    private String questionType;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="questionnaireID", insertable=false, updatable = false)
    private Questionnaire questionnaire;
    @OneToMany(mappedBy="question", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <QuestionOption> options;    
    @OneToMany(mappedBy="question", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Answer> answer;


    public Question() {
    }

    public Question(Long questionID, String question, String questionType) {
        this.questionID = questionID;
        this.question = question;
        this.questionType = questionType;
    }

    public Long getQuestionID() {
        return questionID;
    }


    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }


    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }


    public String getQuestionType() {
        return questionType;
    }


    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
}
