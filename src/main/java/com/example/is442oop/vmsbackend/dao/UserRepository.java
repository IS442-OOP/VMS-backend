package com.example.is442oop.vmsbackend.dao;

import com.example.is442oop.vmsbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findUserByEmail(String email);

  @Query("SELECT u from User u")
  List<User> getAllUsers();
}
