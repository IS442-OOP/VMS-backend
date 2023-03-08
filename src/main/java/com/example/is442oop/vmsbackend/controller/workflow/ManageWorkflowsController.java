package com.example.is442oop.vmsbackend.controller.workflow;

import com.example.is442oop.vmsbackend.entities.Workflow;
import com.example.is442oop.vmsbackend.service.manageworkflows.ManageWorkflowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity createWorkflow(@RequestBody Map<String, String> workflowDetails) {
        return manageWorkflowsService.createWorkflow(workflowDetails);
    }

    @PutMapping("/{workflowid}")
    public ResponseEntity editWorkflow(@PathVariable String workflowid, @RequestBody Map<String,?> workflowDetails){
        return manageWorkflowsService.editWorkflow(workflowid, workflowDetails);
    }


}
