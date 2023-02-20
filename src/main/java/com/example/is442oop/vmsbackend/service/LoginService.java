package com.example.is442oop.vmsbackend.service;

import com.example.is442oop.vmsbackend.dao.UserDao;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.exception.InternalServerException;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import com.example.is442oop.vmsbackend.utils.JwtUtil;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private final UserDao userDao;
  public LoginService(UserDao userDao){
    this.userDao = userDao;
  }

  public ResponseEntity loginUser(User user){
    try {
      User userFromDatabase = userDao.findUser(user.getEmail());
      if (userFromDatabase != null){
        if (userDao.verifyPassword(userFromDatabase.getPassword(), user.getPassword())){
          String token = JwtUtil.jwtBuilder(userFromDatabase.getUserID(), user.getEmail(), user.getName());
          return ResponseUtil.responseLoginSuccess(userFromDatabase.getUserID(), token);
        } else {
          return ResponseUtil.responseNotAuthorized();
        }

      } else {
        return ResponseUtil.responseUserNotFound(user.getEmail());
      }
    } catch (Exception e){
      if (e instanceof NotFoundException){
        throw new NotFoundException(e.getMessage());
      } else {
        throw new InternalServerException(e.getMessage());
      }
    }

  }
}
