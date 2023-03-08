package com.example.is442oop.vmsbackend.service.manageusers;

import com.example.is442oop.vmsbackend.dao.user.UserDao;
import com.example.is442oop.vmsbackend.dao.userworkflow.UserWorkflowDao;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.UserWorkflow;
import com.example.is442oop.vmsbackend.entities.Workflow;
import com.example.is442oop.vmsbackend.exception.InternalServerException;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageUsersService implements ManageUsersInterface {

  private final UserDao userDao;
  private final UserWorkflowDao userworkflowDao;

  @Autowired
  public ManageUsersService(UserDao userDao, UserWorkflowDao userworkflowDao){
    this.userDao = userDao;
    this.userworkflowDao = userworkflowDao;
  }
  public List<User> getAllUsers() {
    return userDao.getAllUsers();
  }

  public List<UserWorkflow> getUserWorkflows(Long userid) {
    return userDao.findUserById(userid).getUserWorkflows();
  }

  public List<UserWorkflow> assignWorkflows(Long userid, List<Workflow> workflows) {
  
    List<UserWorkflow> userworkflows = new ArrayList<UserWorkflow>();
    User user = userDao.findUserById(userid);
    System.out.println(user);
    Long millis = System.currentTimeMillis();
    String dateAssigned = new java.sql.Date(millis).toString();
    String isApproved = "0";

    try {
      for (Workflow workflow: workflows){ 
        System.out.println(workflow);
        UserWorkflow uw = new UserWorkflow(dateAssigned, isApproved, user, workflow);
        userworkflows.add(uw);
        // user.addUserWorkflow(uw);
        // workflow.addUserWorkflow(uw);
        System.out.println(uw);
      }
      return userworkflowDao.assignWorkflows(userworkflows);
    }

    catch (Exception e){
      System.out.println(e);
      throw new InternalServerException(e.getMessage());
    
  }


}
}
