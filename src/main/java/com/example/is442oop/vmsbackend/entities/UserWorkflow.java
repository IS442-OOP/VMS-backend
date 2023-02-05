package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table
public class UserWorkflow {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "answerUserId")
  private Set<Answer> userAnswer;

  @ManyToOne
  @JoinColumn(name = "workflow_id")
  private Workflow workflow;

  @OneToMany(mappedBy = "answerUserWorkflowId")
  private Set<Answer> userWorkflowAnswers;

  private Date dateAssigned;

  private boolean isSubmitted;
  private boolean isApproved;
}
