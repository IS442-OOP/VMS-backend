package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Answer {
  @jakarta.persistence.Id
  @SequenceGenerator(
          name = "answer_sequence",
          sequenceName = "answer_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "answer_sequence"
  )
  private Long Id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "form_id")
  private Long answerFormId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_workflow_id")
  private UserWorkflow answerUserWorkflowId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "field_id")
  private Field answerFieldId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "option_id")
  private Option answerOptionId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User answerUserId;

  private String answer;
}
