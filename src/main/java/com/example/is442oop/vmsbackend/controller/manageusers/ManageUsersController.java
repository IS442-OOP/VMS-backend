package com.example.is442oop.vmsbackend.controller.manageusers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.is442oop.vmsbackend.entities.Workflow;
import com.example.is442oop.vmsbackend.service.manageusers.ManageUsersService;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;

@CrossOrigin(origins = "http://localhost:3000")
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
  public ResponseEntity getAllUsers(){
    return ResponseUtil.responseGetUsersOk(manageUsersService.getAllUsers());
  }
  
  @GetMapping("/{userId}")
  public ResponseEntity getUserWorkflows(@PathVariable Long userId) {
    return ResponseUtil.responseGetUserWorkflowsOk(manageUsersService.getUserWorkflows(userId)); 
  }

  @PostMapping("/{userId}")
  public ResponseEntity assignWorkflows(@PathVariable Long userId, @RequestBody List<String> workflowIds) {
    return ResponseUtil.responseAssignUserWorkflowsOk(manageUsersService.assignWorkflows(userId, workflowIds));
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity unassignWorkflow(@RequestBody Long userworkflowId) {
    return ResponseUtil.responseTaskDeleted(manageUsersService.unassignWorkflow(userworkflowId));
  }
}
