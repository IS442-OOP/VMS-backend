package com.example.is442oop.vmsbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Form {
  @Id
  @SequenceGenerator(
          name = "form_sequence",
          sequenceName = "form_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "form_sequence"
  )

  @JsonIgnore
  @OneToMany(mappedBy = "form")
  private Set<Section> sections = new HashSet<>();

  private Long Id;
  private String name;
  private float revisionNumber;
  private Date effectiveDate;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "workflow_forms",
          inverseJoinColumns = @JoinColumn(name = "workflow_id"),
          joinColumns = @JoinColumn(name = "form_id")
  )
  private Set<Workflow> formWorkflows;

  @OneToMany(mappedBy = "answerFormId")
  private Set<Answer> formAnswers;
}
