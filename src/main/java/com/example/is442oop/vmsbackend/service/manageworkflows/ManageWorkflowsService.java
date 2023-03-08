package com.example.is442oop.vmsbackend.service.manageworkflows;

import com.example.is442oop.vmsbackend.dao.manageworkflows.ManageWorkflowsDao;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.Workflow;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ManageWorkflowsService implements ManageWorkflowsInterface{

    private final ManageWorkflowsDao manageWorkflowsDao;

    @Autowired
    public ManageWorkflowsService(ManageWorkflowsDao manageWorkflowsDao) {
        this.manageWorkflowsDao = manageWorkflowsDao;
    }

    public ResponseEntity retrieveWorkflows() {
        return ResponseUtil.responseOkWorkflow(manageWorkflowsDao.retrieveWorkflows());
    }

    public ResponseEntity createWorkflow(Workflow newworkflow){
        return ResponseUtil.responseOkCreateWorkflow(manageWorkflowsDao.createWorkflow(newworkflow));
    }
//
//    public  ResponseEntity updateWorkflow(Workflow workflow){
//        return ResponseUtil.responseOkUpdateWorkflow(manageWorkflowsDao.updateWorkflow(workflow));
//    }

}
