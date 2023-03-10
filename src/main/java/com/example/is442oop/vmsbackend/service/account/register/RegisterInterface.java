package com.example.is442oop.vmsbackend.service.account.register;

import com.example.is442oop.vmsbackend.entities.User;
import org.springframework.http.ResponseEntity;

public interface RegisterInterface {
  public ResponseEntity registerNonVendor(User user, boolean isAdmin);

  public ResponseEntity registerVendor(User user);
}
