package com.example.is442oop.vmsbackend.service.user.updateDetails;

import com.example.is442oop.vmsbackend.dao.user.UserDao;
import com.example.is442oop.vmsbackend.dto.request.UpdateUserDetailsDto;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.UserType;
import com.example.is442oop.vmsbackend.exception.InternalServerException;
import com.example.is442oop.vmsbackend.utils.JwtUtil;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserDetailsService {
  private final UserDao userDao;

  @Autowired
  public UpdateUserDetailsService(UserDao userDao){
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
}
