package com.example.is442oop.vmsbackend.service.login;

import com.example.is442oop.vmsbackend.entities.User;
import org.springframework.http.ResponseEntity;

public interface LoginInterface {
  public ResponseEntity handle(User user);
}
