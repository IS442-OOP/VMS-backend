package com.example.is442oop.vmsbackend.dao.userworkflow;

import com.example.is442oop.vmsbackend.entities.UserWorkflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserWorkflowRepository extends JpaRepository<UserWorkflow, Long> {
  @Query("SELECT u from User u where u.userID=?1")
  List<UserWorkflow> getUserWorkflows(Long userid);
}
