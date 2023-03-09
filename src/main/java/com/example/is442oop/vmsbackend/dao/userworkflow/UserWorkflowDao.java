package com.example.is442oop.vmsbackend.dao.userworkflow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.is442oop.vmsbackend.entities.UserWorkflow;


@Component
public class UserWorkflowDao {
    private final UserWorkflowRepository userworkflowRepository;


    @Autowired
    public UserWorkflowDao(UserWorkflowRepository userworkflowRepository) {
        this.userworkflowRepository = userworkflowRepository;
    }

    public List<UserWorkflow> assignWorkflows(List<UserWorkflow> workflows) {
        try {
            return userworkflowRepository.saveAll(workflows);
        } catch (Exception e) {
        }
        return null;
        
    }

    public UserWorkflow getUserWorkflowById(Long userworkflowid) {
        try{
            return userworkflowRepository.findById(userworkflowid).get();
        } catch (Exception e) {
        }
        return null;
    }

    public void unassignWorkflow(Long userworkflowid) {
        try {
            userworkflowRepository.deleteById(userworkflowid);
        } catch (Exception e) {
        }
        
    }
}
