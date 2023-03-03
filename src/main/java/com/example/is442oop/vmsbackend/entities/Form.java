package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Form {
    @Id
    private Long formID;
    private String HTML;
    @OneToMany(mappedBy="form", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Questionnaire> questionnaire;

    
    public Form(Long formID, String hTML) {
        this.formID = formID;
        HTML = hTML;
    }

    public Form(){

    }


    public Long getFormID() {
        return formID;
    }
    public void setFormID(Long formID) {
        this.formID = formID;
    }
    public String getHTML() {
        return HTML;
    }
    public void setHTML(String hTML) {
        HTML = hTML;
    }


}
