package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Section {
  @Id
  @SequenceGenerator(
          name = "section_sequence",
          sequenceName = "section_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "section_sequence"
  )
  private Long Id;
  private String title;
  private String description;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="form_id")
  private Form form;
}
