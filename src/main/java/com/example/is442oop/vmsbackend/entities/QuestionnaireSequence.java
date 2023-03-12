package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

@Entity
public class QuestionnaireSequence {

  @Id
  @OneToOne(cascade= CascadeType.ALL)
  @JoinColumn(name = "sequenceID")
  private Sequence sequence;

  @ManyToOne(cascade= CascadeType.ALL)
  @JoinColumn(name = "questionnaireID", insertable = true, updatable = false)
  private Questionnaire questionnaire;

  public QuestionnaireSequence() {

  }
  public QuestionnaireSequence(Sequence sequence, Questionnaire questionnaire){
    this.sequence = sequence;
    this.questionnaire = questionnaire;
  }

  public void setSequence(Sequence sequence) {
    this.sequence = sequence;
  }
}
