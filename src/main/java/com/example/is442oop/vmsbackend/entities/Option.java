package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Option {
  @jakarta.persistence.Id
  @SequenceGenerator(
          name = "option_sequence",
          sequenceName = "option_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "option_sequence"
  )
  private Long Id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "field_id")
  private Field field;

  @OneToMany(mappedBy = "answerOptionId")
  private Set<Answer> optionAnswers;

  private String value;
  private boolean isSelectedDefault;
  private boolean isOpenEnded;
}
