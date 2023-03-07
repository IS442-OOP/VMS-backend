package com.example.is442oop.vmsbackend.dao.manageworkflows;

import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.Workflow;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManageWorkflowsRepository extends JpaRepository<Workflow, String> {
    @Query("SELECT w from Workflow w")
    List<Workflow> getAllWorkflows();

    @Modifying
    @Transactional
    @Query("UPDATE Workflow w SET w.workflowid = :workflowid, name= :name WHERE w.workflowid = :workflowid")
    Workflow updateWorkflow(@Param("workflowid") String workflowid, @Param("name") String name);
}
