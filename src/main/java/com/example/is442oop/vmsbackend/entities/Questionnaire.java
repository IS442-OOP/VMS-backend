package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionnaireID;
    private String name;
    private String description;
    private String dateCreated;

    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<Question> questions;

    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<QuestionnaireSequence> sequenceQuestionnaires;

    @OneToMany(mappedBy = "questionnaireToApprove", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<ApprovalSequence> sequenceApprovals;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "formID", insertable = false, updatable = false)
    private Form form;

    public Questionnaire(String name, String description, String dateCreated) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.questions = new ArrayList<Question>();
    }

    public Questionnaire(String name, String description) {
        this.name = name;
        this.description = description;
        this.questions = new ArrayList<Question>();
    }

    public Questionnaire() {

    }

    public String getDescription() {
        return description;
    }

    public Long getQuestionnaireID() {
        return questionnaireID;
    }

    public void setQuestionnaireID(Long questionnaireID) {
        this.questionnaireID = questionnaireID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void clearQuestions() {
        this.questions.clear();

    }

    public Question getQuestionById(Long id) {

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            if (question.getQuestionID() == id) {
                return question;
            }
        }

        return null;
    }

    public void removeQuestionById(Long id) {
        for (Question question : questions) {
            if (question.getQuestionID() == id) {
                questions.remove(question);
                return;
            }
        }
    }
}
