package com.example.is442oop.vmsbackend.dao.manageworkflows;

import com.example.is442oop.vmsbackend.entities.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManageWorkflowsRepository extends JpaRepository<Workflow, String> {
    @Query("SELECT w from Workflow w")
    List<Workflow> getAllWorkflows();
}
