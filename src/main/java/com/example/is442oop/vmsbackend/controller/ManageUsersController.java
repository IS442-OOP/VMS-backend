package com.example.is442oop.vmsbackend.controller;

import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.UserWorkflow;
import com.example.is442oop.vmsbackend.entities.Workflow;
import com.example.is442oop.vmsbackend.service.manageusers.ManageUsersService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manageusers")
public class ManageUsersController {

  private final ManageUsersService manageUsersService;

  @Autowired
  public ManageUsersController(ManageUsersService manageUsersService) {
    this.manageUsersService = manageUsersService;
  }

  @GetMapping
  public ResponseEntity getAllUsers(@RequestBody User user){
    return null;
  }

  @GetMapping("/{user}")
  public ResponseEntity getUserWorkflows(@RequestBody Integer userId) {
    return null;
  }

//   @PostMapping
//   public ResponseEntity assignWorkflow(@RequestBody ArrayList<Workflow> workflows) {
//     return null;
//   }
}
