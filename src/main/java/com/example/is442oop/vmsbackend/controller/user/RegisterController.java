package com.example.is442oop.vmsbackend.controller.user;

import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.service.user.register.RegisterService;
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
  public ResponseEntity registerAdmin(@RequestBody User user) {
    return registerService.registerNonVendor(user, true);
  }

  @PostMapping(path = "/vendor")
  public ResponseEntity registerVendor(@RequestBody User user) {
    return registerService.registerVendor(user);
  }

  @PostMapping(path = "/approver")
  public ResponseEntity registerApprover(@RequestBody User user) {
    return registerService.registerNonVendor(user, false);
  }
}
