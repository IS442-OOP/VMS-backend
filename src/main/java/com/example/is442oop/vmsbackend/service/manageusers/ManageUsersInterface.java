package com.example.is442oop.vmsbackend.service.manageusers;

import com.example.is442oop.vmsbackend.entities.User;
import org.springframework.http.ResponseEntity;

public interface ManageUsersInterface {
  public ResponseEntity handle(User user);
}
