package com.example.is442oop.vmsbackend.dao.userworkflow;


import com.example.is442oop.vmsbackend.entities.UserWorkflow;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserWorkflowDao {
  private final UserWorkflowRepository userworkflowRepository;

  @Autowired
  public UserWorkflowDao(UserWorkflowRepository userworkflowRepository){
    this.userworkflowRepository = userworkflowRepository;
  }

  public List<UserWorkflow> getUserWorkflows(Long userId) {
    return userworkflowRepository.getUserWorkflows(userId);
  }
}
