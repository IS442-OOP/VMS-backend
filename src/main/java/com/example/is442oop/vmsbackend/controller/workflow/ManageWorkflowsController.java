package com.example.is442oop.vmsbackend.controller.workflow;

import com.example.is442oop.vmsbackend.entities.Workflow;
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
    public ResponseEntity retrieveWorkflows(){
        return manageWorkflowsService.retrieveWorkflows();
    }

    @PostMapping
    public ResponseEntity createWorkflow(@RequestBody Workflow newworkflow) {
        return manageWorkflowsService.createWorkflow(newworkflow);
    }

    @PutMapping(path = "/update")
    public ResponseEntity updateWorkflow(@RequestBody Workflow workflow){
        return manageWorkflowsService.updateWorkflow(workflow);
    }
}
