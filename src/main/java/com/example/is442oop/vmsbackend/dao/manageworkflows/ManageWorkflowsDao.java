package com.example.is442oop.vmsbackend.dao.manageworkflows;

import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.entities.Sequence;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.Workflow;
import com.example.is442oop.vmsbackend.exception.InternalServerException;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public Workflow createWorkflow(Map<String, ?> workflowDetails) {
        String workflowNo = (String) workflowDetails.get("workflowNo");
        System.out.println(workflowNo);
        String name = (String) workflowDetails.get("name");
        try {
            Workflow newWorkflow = new Workflow(name, workflowNo);
            return manageWorkflowsRepository.save(newWorkflow);
        } catch (InternalServerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void editWorkflow(String workflowID, Map<String, ?> workflowDetails) {
        try{
            manageWorkflowsRepository.findById(workflowID);
            String name = (String) workflowDetails.get("name");
            String workflowNo = (String) workflowDetails.get("workflowNo");
            manageWorkflowsRepository.updateWorkflow(workflowID, name, workflowNo);
        }
        catch (NotFoundException e){
            throw new NotFoundException("Workflow not found for ID :" + workflowID);
        }
    }

    public Set<Sequence> getListOfSequences(String workflowID, Map<String, ?> workflowDetails) {
        try{
            Workflow workflow = manageWorkflowsRepository.findById(workflowID).orElse(null);

            return workflow.getListOfSequences();
        }
        catch (NotFoundException e){
            throw new NotFoundException("Workflow not found for ID :" + workflowID);
        }
    }
}
