package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;

@Entity
public class QuestionOption {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer optionID;
    private String questionOption;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionID")
    private Question question;

    
    public QuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }

    public QuestionOption(){

    }


    public Integer getOptionID() {
        return optionID;
    }


    public void setOptionID(Integer optionID) {
        this.optionID = optionID;
    }


    public String getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }

    public void setQuestion(Question question){
        this.question= question;
    }


    
}
