package com.example.is442oop.vmsbackend.controller;

import com.example.is442oop.vmsbackend.service.manageworkflows.ManageWorkflowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manageworkflows")
public class ManageWorkflowsController {

    private final ManageWorkflowsService manageWorkflowsService;

    @Autowired
    public ManageWorkflowsController(ManageWorkflowsService manageWorkflowsService) {
        this.manageWorkflowsService = manageWorkflowsService;
    }
    @GetMapping
    public ResponseEntity retrieveWorkflows(@RequestAttribute(name="Authorization") String token){
        return manageWorkflowsService.retrieveWorkflows();
    }
}
