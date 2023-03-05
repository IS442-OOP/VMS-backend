package com.example.is442oop.vmsbackend.service.register;

import com.example.is442oop.vmsbackend.dao.user.UserDao;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.UserType;
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

  public ResponseEntity registerNonVendor(User user, boolean isAdmin) {
    System.out.println("HI");
    if (isAdmin) {
      user.setUserType(new UserType(1L, "Admin"));
    } else {
      user.setUserType(new UserType(2L, "Approver"));
    }
    user.setAccountActivated(true);

    try {
      if (userDao.isUserPresent(user.getEmail())) {
        return ResponseUtil.responseConflict(user.getEmail());
      } else {
        try {
          String token = JwtUtil.jwtBuilder(user.getUserID(), user.getEmail(), user.getName());
          userDao.hashPassword(user, user.getPassword());
          userDao.registerUser(user);
          User newUser = userDao.findUser(user.getEmail());
          return ResponseUtil.responseUserCreated(newUser.getUserID(), token);
        } catch (Exception e) {
          throw new InternalServerException(e.getMessage());
        }
      }
    } catch (Exception e) {
      System.out.println(e);
      throw new InternalServerException(e.getMessage());
    }
  }

  public ResponseEntity registerVendor(User user){
    user.setAccountActivated(false);
    user.setUserType(new UserType(3L, "Vendor"));
    try {
      if (userDao.isUserPresent(user.getEmail())) {
        return ResponseUtil.responseConflict(user.getEmail());
      } else {
          userDao.registerUser(user);
          User newUser = userDao.findUser(user.getEmail());
          return ResponseUtil.responseVendorCreated(newUser);
      }
    } catch (Exception e) {
      System.out.println(e);
      throw new InternalServerException(e.getMessage());
    }

  }
}
