package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

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
  private Long userId;
  private String name;
  private String email;
  private String password;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "usertype_id", referencedColumnName = "userTypeId")
  private UserType userType;

  public User(){
  }
  public User(Long id, String name, String email, String password) {
    this.userId = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return userId;
  }

  public void setId(Long id) {
    userId = id;
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
