package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Workflow {
  @Id
  @SequenceGenerator(
          name = "workflow_sequence",
          sequenceName = "workflow_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "workflow_sequence"
  )
  private Long Id;

  private String name;

  @ManyToMany(mappedBy = "formWorkflows")
  private Set<Form> forms;

  @ManyToMany(mappedBy = "userWorkFlows")
  private Set<User> users;
}
