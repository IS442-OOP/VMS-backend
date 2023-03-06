package com.example.is442oop.vmsbackend.service.account.login;

import com.example.is442oop.vmsbackend.dao.user.UserDao;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.exception.InternalServerException;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import com.example.is442oop.vmsbackend.utils.JwtUtil;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginInterface {

  private final UserDao userDao;

  @Autowired
  public LoginService(UserDao userDao){
    this.userDao = userDao;
  }

  public ResponseEntity handle(User user){
    try {
      User userFromDatabase = userDao.findUser(user.getEmail());
      System.out.println(userFromDatabase.toString());
      
      if (userFromDatabase != null){
        if (userDao.verifyPassword(userFromDatabase.getPassword(), user.getPassword())){
          String token = JwtUtil.jwtBuilder(userFromDatabase.getUserID(), user.getEmail(), user.getName());
          System.out.println(token);
          return ResponseUtil.responseLoginSuccess(userFromDatabase.getUserID(), token, userFromDatabase);
        } else {
          return ResponseUtil.responseNotAuthorized();
        }

      } else {
        return ResponseUtil.responseUserNotFound(user.getEmail());
      }
    } catch (Exception e){
      if (e instanceof NotFoundException){
        
        e.printStackTrace();
        throw new NotFoundException(e.getMessage());
      } else {
        e.printStackTrace();
        throw new InternalServerException(e.getMessage());
       
      }
    }

  }
}
