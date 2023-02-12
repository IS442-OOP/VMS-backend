package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="question")
public class Question {
    @Id
    private Integer questionID;
    private String question; 
    private String questionType;
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="sectionID", insertable=false, updatable = false)
    private Section section;
    @OneToMany(mappedBy="question", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List <QuestionOption> options;    
    @OneToMany(mappedBy="question", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List <Answer> answer;



    public Question(Integer questionID, String question, String questionType) {
        this.questionID = questionID;
        this.question = question;
        this.questionType = questionType;
    }
    
    public Integer getQuestionID() {
        return questionID;
    }


    public void setQuestionID(Integer questionID) {
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
