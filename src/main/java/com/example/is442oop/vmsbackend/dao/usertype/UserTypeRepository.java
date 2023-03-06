package com.example.is442oop.vmsbackend.dao.usertype;

import com.example.is442oop.vmsbackend.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
