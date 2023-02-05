package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Field {
  @Id
  @SequenceGenerator(
          name = "field_sequence",
          sequenceName = "field_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "field_sequence"
  )
  private Long Id;

  @OneToMany(mappedBy = "answerFieldId")
  private Set<Answer> fieldAnswers;

  private String type;
  private String label;
  private boolean isRequired;
  private boolean isReadOnly;

}
