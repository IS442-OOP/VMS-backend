package com.example.is442oop.vmsbackend.service.manageworkflows;

import com.example.is442oop.vmsbackend.dao.ManageWorkflowsDao;
import com.example.is442oop.vmsbackend.entities.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageWorkflowsService implements ManageWorkflowsInterface{

    private final ManageWorkflowsDao manageWorkflowsDao;

    @Autowired
    public ManageWorkflowsService(ManageWorkflowsDao manageWorkflowsDao) {
        this.manageWorkflowsDao = manageWorkflowsDao;
    }

    public List<Workflow> retrieveWorkflows() {

        List<Workflow> workflows = manageWorkflowsDao.retrieveWorkflows();
        return workflows;

    }

}
