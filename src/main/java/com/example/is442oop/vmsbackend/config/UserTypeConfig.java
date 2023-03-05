package com.example.is442oop.vmsbackend.config;

import com.example.is442oop.vmsbackend.dao.usertype.UserTypeRepository;
import com.example.is442oop.vmsbackend.entities.UserType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserTypeConfig implements CommandLineRunner {

  private final UserTypeRepository userTypeRepository;

  public UserTypeConfig(UserTypeRepository userTypeRepository) {
    this.userTypeRepository = userTypeRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    UserType userType1 = new UserType(100L, "Admin");
    UserType userType2 = new UserType(101L, "Approver");
    UserType userType3 = new UserType(103L, "Vendor");

    userTypeRepository.save(userType1);
    userTypeRepository.save(userType2);
    userTypeRepository.save(userType3);
  }
}
