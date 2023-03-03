package com.example.is442oop.vmsbackend.dao;

import com.example.is442oop.vmsbackend.entities.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManageWorkflowsDao {
    private final ManageWorkflowsRepository manageWorkflowsRepository;

    @Autowired
    public ManageWorkflowsDao(ManageWorkflowsRepository manageWorkflowsRepository) {
        this.manageWorkflowsRepository = manageWorkflowsRepository;
    }

    public List<Workflow> retrieveWorkflows() {
        return manageWorkflowsRepository.getAllWorkflows();
    }
}
