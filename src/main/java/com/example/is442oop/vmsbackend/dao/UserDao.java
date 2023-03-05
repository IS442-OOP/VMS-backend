package com.example.is442oop.vmsbackend.dao;

import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import com.example.is442oop.vmsbackend.exception.UserForbiddenException;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Component
public class UserDao {
  private final UserRepository userRepository;

  @Autowired
  public UserDao(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public void registerUser(User user) {
    userRepository.save(user);
  }

  public List<User> retrieveUsers() {
    return userRepository.getAllUsers();
  }

  public User findUser(String email){
    try {
      return userRepository.findUserByEmail(email).get();
    } catch (Exception e) {
      if (e instanceof CannotCreateTransactionException){
        throw e;
      }
      throw new NotFoundException("User cannot be found for email: " + email);
    }
  }

  public boolean isUserPresent(String email){
    try{
      return userRepository.findUserByEmail(email).isPresent();
    } catch (Exception e) {
      if (e instanceof CannotCreateTransactionException) {
        throw e;
      }
      throw new NotFoundException("User cannot be found for email: " + email);
    }

  }

  public void hashPassword(User user, String password){
    Base64.Encoder encoder = Base64.getEncoder();
    user.setPassword(encoder.encodeToString(password.getBytes()));
  }

  public boolean verifyPassword(String encryptedPassword, String enteredPassword){
    Base64.Decoder decoder = Base64.getDecoder();
    byte[] bytes = decoder.decode(encryptedPassword);
    return Objects.equals(new String(bytes), enteredPassword);
  }
}
