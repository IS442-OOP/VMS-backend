package com.example.is442oop.vmsbackend.dao.user;

import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

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

  public User getUser(String userId) throws Exception {
      Optional<User> user = userRepository.findById(Long.valueOf(userId));
      if (user.isPresent()) {
        return user.get();
      } else {
        throw new NotFoundException("User does not exist for id: " + userId);
      }

  }

  public void hashPassword(User user, String password){
    Base64.Encoder encoder = Base64.getEncoder();
    user.setPassword(encoder.encodeToString(password.getBytes()));
  }

  public String hashPassword(String password){
    Base64.Encoder encoder = Base64.getEncoder();
    return encoder.encodeToString(password.getBytes());
  }

  public boolean verifyPassword(String encryptedPassword, String enteredPassword){
    Base64.Decoder decoder = Base64.getDecoder();
    byte[] bytes = decoder.decode(encryptedPassword);
    return Objects.equals(new String(bytes), enteredPassword);
  }

  public void updatePassword(int userId, String password) throws Exception {
    userRepository.updatePassword(Long.valueOf(userId), password);
  }
}
