package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

@Entity
public class ApprovalSequence {
  @Id
  @OneToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
  @JoinColumn(name = "sequenceID")
  private Sequence sequence;

  @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
  @JoinColumn(name = "questionnaireID", insertable = false, updatable = false)
  private Questionnaire questionnaireToApprove;
}
