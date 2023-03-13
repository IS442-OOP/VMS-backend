package com.example.is442oop.vmsbackend.dao.user;

import com.example.is442oop.vmsbackend.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findUserByEmail(String email);

  @Modifying
  @Transactional
  @Query("UPDATE User u SET u.password = :password WHERE u.id = :id")
  User updatePassword(@Param("id") Long id, @Param("password") String password);
}
