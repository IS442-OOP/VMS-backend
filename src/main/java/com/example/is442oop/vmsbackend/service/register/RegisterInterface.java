package com.example.is442oop.vmsbackend.service.register;

import com.example.is442oop.vmsbackend.entities.User;
import org.springframework.http.ResponseEntity;

public interface RegisterInterface {
  public ResponseEntity registerUser(User user);
}
