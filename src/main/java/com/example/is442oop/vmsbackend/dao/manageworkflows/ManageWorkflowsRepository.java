package com.example.is442oop.vmsbackend.dao.manageworkflows;

import com.example.is442oop.vmsbackend.entities.Sequence;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.Workflow;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ManageWorkflowsRepository extends JpaRepository<Workflow, String> {
    @Query("SELECT w from Workflow w")
    List<Workflow> getAllWorkflows();

//    @Query("SELECT w FROM Workflow w WHERE w.workflowID = :workflowID")
//    Workflow getWorkflowByworkflowID(@Param("workflowID") String workflowID);

    @Modifying
    @Transactional
    @Query("UPDATE Workflow w SET w.name = :name, w.workflowNo = :workflowNo WHERE w.workflowID = :workflowID")
    void updateWorkflow(@Param("workflowID") String workflowID, @Param("name") String name, @Param("workflowNo") String workflowNo);

}
