package com.example.is442oop.vmsbackend.service.manageworkflows;

import com.example.is442oop.vmsbackend.entities.Workflow;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ManageWorkflowsInterface {
    public ResponseEntity retrieveWorkflows();
}
