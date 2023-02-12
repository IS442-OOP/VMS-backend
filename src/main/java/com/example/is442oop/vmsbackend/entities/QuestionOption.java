package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;

@Entity
@Table(name="options")
public class QuestionOption {
    @Id
    private Integer optionID;
    private String questionOption;
    private String optionType;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "questionID", insertable = false, updatable = false, nullable = true)
    private Question question;

    
    public QuestionOption(Integer optionID, String questionOption, String optionType) {
        this.optionID = optionID;
        this.questionOption = questionOption;
        this.optionType = optionType;
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


    
}
