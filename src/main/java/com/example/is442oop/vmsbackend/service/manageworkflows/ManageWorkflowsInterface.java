package com.example.is442oop.vmsbackend.service.manageworkflows;

import com.example.is442oop.vmsbackend.entities.Workflow;
import org.hibernate.jdbc.Work;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ManageWorkflowsInterface {
    public ResponseEntity retrieveWorkflows();
    public ResponseEntity createWorkflow(Workflow newworkflow);

    public ResponseEntity updateWorkflow(Workflow workflow);
}
