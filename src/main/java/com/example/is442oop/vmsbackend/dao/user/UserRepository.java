package com.example.is442oop.vmsbackend.dao.user;

import com.example.is442oop.vmsbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findStudentByEmail(String email);
}
