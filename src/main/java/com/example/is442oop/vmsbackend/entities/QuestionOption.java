package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;

@Entity
public class QuestionOption {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer optionID;
    private String questionOption;
    private String optionType;
    
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "questionID", insertable = false, updatable = false, nullable = true)
    private Question question;


    public QuestionOption() {
    }

    public QuestionOption(Integer optionID, String questionOption, String optionType) {
        this.optionID = optionID;
        this.questionOption = questionOption;
        this.optionType = optionType;
    }

    public QuestionOption(){

    }


    public Integer getOptionID() {
        return optionID;
    }


    public void setOptionID(Integer optionID) {
        this.optionID = optionID;
    }


    public String getOption() {
        return questionOption;
    }


    public void setOption(String questionOption) {
        this.questionOption = questionOption;
    }


    public String getOptionType() {
        return optionType;
    }


    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }  

    public void setQuestion(Question question){
        this.question= question;
    }


    
}
