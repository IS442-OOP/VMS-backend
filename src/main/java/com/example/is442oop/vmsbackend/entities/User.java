package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class User {

  @Id
  @SequenceGenerator(
          name = "user_sequence",
          sequenceName = "user_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "user_sequence"
  )
  private Long Id;
  private String name;
  private String email;
  private String password;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
          name = "user_workflow",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "workflow_id")
  )
  private Set<Workflow> userWorkFlows;

  public User(){
  }
  public User(Long id, String name, String email, String password) {
    this.Id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
