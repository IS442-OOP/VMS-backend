package com.example.is442oop.vmsbackend.controller;

import com.example.is442oop.vmsbackend.service.manageworkflows.ManageWorkflowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manageworkflows")
public class ManageWorkflowsController {

    private final ManageWorkflowsService manageWorkflowsService;

    @Autowired
    public ManageWorkflowsController(ManageWorkflowsService manageWorkflowsService) {
        this.manageWorkflowsService = manageWorkflowsService;
    }
    @GetMapping
    public @ResponseBody Object retrieveWorkflows(){
        return manageWorkflowsService.retrieveWorkflows();
    }
}
