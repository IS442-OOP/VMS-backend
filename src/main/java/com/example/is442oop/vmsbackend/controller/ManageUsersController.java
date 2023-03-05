package com.example.is442oop.vmsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.UserWorkflow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.is442oop.vmsbackend.dao.UserRepository;
import com.example.is442oop.vmsbackend.service.manageusers.ManageUsersService;

@RestController
@RequestMapping("/api/v1/manageusers")
public class ManageUsersController {

  private final ManageUsersService manageUsersService;

  @Autowired
  public ManageUsersController(ManageUsersService manageUsersService) {
    this.manageUsersService = manageUsersService;
  }


  // @RequestAttribute("userId") String id
  @GetMapping
  public List<User> getAllUsers(){
    return manageUsersService.getAllUsers();
  }

  
  // @GetMapping("/{userId}")
  // public List<UserWorkflow> getUserWorkflows(@RequestAttribute("userId") Long userId) {
  //   return manageUsersService.getUserWorkflows(userId); 
  // }

  // @PostMapping("/{userId}")
  // public ResponseEntity assignWorkflows(@RequestBody ArrayList<Workflow> workflows) {
  //   return manageUsersService.assignWorkflows;
  // }
}
