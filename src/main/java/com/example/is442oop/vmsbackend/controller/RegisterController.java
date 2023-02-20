package com.example.is442oop.vmsbackend.controller;

import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/user/register", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {

  private final RegisterService registerService;

  @Autowired
  public RegisterController(RegisterService registerService){
    this.registerService = registerService;
  }

  @PostMapping
  public ResponseEntity registerUser(@RequestBody User user){
    return registerService.registerUser(user);
  }
}
