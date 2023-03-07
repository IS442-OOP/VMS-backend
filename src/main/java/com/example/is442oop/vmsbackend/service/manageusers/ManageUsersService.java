package com.example.is442oop.vmsbackend.service.manageusers;

import com.example.is442oop.vmsbackend.dao.UserDao;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.UserWorkflow;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageUsersService implements ManageUsersInterface {

  private final UserDao userDao;

  @Autowired
  public ManageUsersService(UserDao userDao){
    this.userDao = userDao;
  }
  public List<User> getAllUsers() {
    return userDao.getAllUsers();
  }

  public List<UserWorkflow> getUserWorkflows(Long userid) {

    User user = userDao.findUserById(userid);
    return user.getUserWorkflows();

  }


}
