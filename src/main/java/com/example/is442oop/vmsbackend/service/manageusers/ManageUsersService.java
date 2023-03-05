package com.example.is442oop.vmsbackend.service.manageusers;

import com.example.is442oop.vmsbackend.authentication.BasicAuthInterceptor;
import com.example.is442oop.vmsbackend.dao.UserDao;
import com.example.is442oop.vmsbackend.dao.userworkflow.UserWorkflowDao;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.UserWorkflow;
import com.example.is442oop.vmsbackend.exception.InternalServerException;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import com.example.is442oop.vmsbackend.exception.UserForbiddenException;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    return userworkflowDao.getUserWorkflows(userid);
  }


}
