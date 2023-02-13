package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Form {
    @Id
    private Integer formID;
    private String HTML;
    @OneToMany(mappedBy="form", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Questionnaire> questionnaire;

    
    public Form(Integer formID, String hTML) {
        this.formID = formID;
        HTML = hTML;
    }

    public Form(){

    }


    public Integer getFormID() {
        return formID;
    }
    public void setFormID(Integer formID) {
        this.formID = formID;
    }
    public String getHTML() {
        return HTML;
    }
    public void setHTML(String hTML) {
        HTML = hTML;
    }


}
