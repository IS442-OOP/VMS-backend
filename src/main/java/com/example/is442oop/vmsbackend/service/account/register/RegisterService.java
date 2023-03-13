package com.example.is442oop.vmsbackend.service.account.register;

import com.example.is442oop.vmsbackend.dao.user.UserDao;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.exception.InternalServerException;
import com.example.is442oop.vmsbackend.utils.JwtUtil;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements RegisterInterface {
  private final UserDao userDao;

  @Autowired
  public RegisterService(UserDao userDaoUtils){
    this.userDao = userDaoUtils;
  }

  public ResponseEntity handle(User user){
    System.out.println(user.toString());
    try {
      if (userDao.isUserPresent(user.getEmail())){
        return ResponseUtil.responseConflict(user.getEmail());
      } else {
        try {
          String token = JwtUtil.jwtBuilder(user.getUserID(), user.getEmail(), user.getName());
          userDao.hashPassword(user, user.getPassword());
          userDao.registerUser(user);
          User newUser = userDao.findUser(user.getEmail());
          return ResponseUtil.responseUserCreated(newUser.getUserID(), token);
        } catch (Exception e){
          throw new InternalServerException(e.getMessage());
        }
      }
    } catch (Exception e){
      System.out.println(e);
      throw new InternalServerException(e.getMessage());
    }
  }
}
