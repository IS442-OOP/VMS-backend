package com.example.is442oop.vmsbackend.dao;


import java.util.*;
import org.springframework.data.jpa.repository.Query;
import com.example.is442oop.vmsbackend.entities.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowRepository extends JpaRepository<Workflow, Integer> {
  @Query("select w from Workflow w WHERE w.workflowID=?1")
  List <Workflow> getAllWorkflowById(Integer workflowID);
}
