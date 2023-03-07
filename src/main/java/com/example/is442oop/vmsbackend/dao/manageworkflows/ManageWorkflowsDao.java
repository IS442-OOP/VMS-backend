package com.example.is442oop.vmsbackend.dao.manageworkflows;

import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.Workflow;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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


    public Workflow createWorkflow(Workflow newworkflow) {
        return manageWorkflowsRepository.save(newworkflow);
    }
    public Workflow updateWorkflow(Workflow workflow) {
        return manageWorkflowsRepository.updateWorkflow(workflow.getWorkflowID(), workflow.getName());
    }
}
