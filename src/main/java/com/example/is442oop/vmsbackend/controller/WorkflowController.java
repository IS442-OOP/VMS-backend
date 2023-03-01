package com.example.is442oop.vmsbackend.controller;

import com.example.is442oop.vmsbackend.dao.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/workflows")

public class WorkflowController {
    @Autowired
    private WorkflowRepository workflowRepository;

    
    @GetMapping("/{workflowId}")
    public @ResponseBody Object getWorkflowById(@PathVariable Integer workflowId ){
        return workflowRepository.getAllWorkflowById(workflowId);
    }
    

}
