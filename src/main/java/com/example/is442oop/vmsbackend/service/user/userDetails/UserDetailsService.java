package com.example.is442oop.vmsbackend.service.user.userDetails;

import com.example.is442oop.vmsbackend.dao.user.UserDao;
import com.example.is442oop.vmsbackend.dto.request.UpdateUserDetailsDto;
import com.example.is442oop.vmsbackend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
  private final UserDao userDao;

  @Autowired
  public UserDetailsService(UserDao userDao){
    this.userDao = userDao;
  }

  public boolean updatePassword(UpdateUserDetailsDto updateUserDetailsDto, String userId)
  throws Exception {
      if (updateUserDetailsDto.getNewPassword()
              .equals(updateUserDetailsDto.getConfirmPassword())) {
        String hashPassword = userDao.hashPassword(updateUserDetailsDto.getNewPassword());
        userDao.updatePassword(Integer.parseInt(userId), hashPassword);
        return true;
      } else {
        return false;
      }

  }

  public User getUserDetails(String userId)
          throws Exception {
    return userDao.getUser(userId);
  }
}
