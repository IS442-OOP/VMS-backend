package com.example.is442oop.vmsbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class UserType {

  @Id
  @SequenceGenerator(
          name = "usertype_sequence",
          sequenceName = "usertype_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "usertype_sequence"
  )
  private Long userTypeId;
  private String userType;
  private boolean hasAdminAccess;

  @JsonIgnore
  @OneToMany(mappedBy = "usertype")
  private Set<User> users = new HashSet<User>();
}
