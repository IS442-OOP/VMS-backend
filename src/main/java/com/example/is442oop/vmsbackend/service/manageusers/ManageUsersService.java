package com.example.is442oop.vmsbackend.service.manageusers;

import com.example.is442oop.vmsbackend.authentication.BasicAuthInterceptor;
import com.example.is442oop.vmsbackend.dao.UserDao;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.UserWorkflow;
import com.example.is442oop.vmsbackend.exception.InternalServerException;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import com.example.is442oop.vmsbackend.utils.JwtUtil;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ManageUsersService implements ManageUsersInterface {

  private final UserDao userDao;

  @Autowired
  public ManageUsersService(UserDao userDao){
    this.userDao = userDao;
  }
  public List<User> retrieveUsers() {
    
    List<User> users = userDao.retrieveUsers();
    return users;
    
  }

}
