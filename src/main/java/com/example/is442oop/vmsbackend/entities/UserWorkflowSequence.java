package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

@Entity
public class UserWorkflowSequence {

  @Id
  @SequenceGenerator(
          name = "userWorkflowSequence_sequence",
          sequenceName = "userWorkflowSequence_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "userWorkflowSequence_sequence"
  )
  private Long userWorkflowSequenceId;
  private boolean isDone;
  @ManyToOne(cascade= CascadeType.ALL, optional = true)
  @JoinColumn(name="userWorkflowID", insertable=false, updatable = false, nullable=true)
  private UserWorkflow userWorkflow;

  @ManyToOne(cascade= CascadeType.ALL, optional = true)
  @JoinColumn(name="sequenceID", insertable=false, updatable = false, nullable=true)
  private Sequence sequenceForUserWorkflow;
}
