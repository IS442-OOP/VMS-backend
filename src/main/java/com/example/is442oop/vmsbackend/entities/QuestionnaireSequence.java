package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

@Entity
public class QuestionnaireSequence {

  @Id
  @OneToOne(cascade= CascadeType.ALL)
  @JoinColumn(name = "sequenceID")
  private Sequence sequence;

  @ManyToOne(cascade= CascadeType.ALL)
  @JoinColumn(name = "questionnaireID", insertable = false, updatable = false)
  private Questionnaire questionnaire;
}
