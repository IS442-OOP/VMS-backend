package com.example.is442oop.vmsbackend.controller.account;

import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.service.account.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account/login")
public class LoginController {

  private final LoginService loginService;

  @Autowired
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping
  public ResponseEntity loginUser(@RequestBody User user){
    return loginService.handle(user);
  }
}
