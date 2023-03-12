package com.example.is442oop.vmsbackend.service.manageworkflows;

import com.example.is442oop.vmsbackend.entities.Sequence;
import com.example.is442oop.vmsbackend.entities.Workflow;
import org.hibernate.jdbc.Work;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ManageWorkflowsInterface {
    public ResponseEntity retrieveWorkflows();

    public ResponseEntity createWorkflow(Map<String, ?> workflowDetails);

    public ResponseEntity editWorkflow(String workflowID, Map<String, ?> workflowDetails);

    public Set<Sequence> getListOfSequences(String workflowID);

    public ResponseEntity addWorkflowSequence(String workflowid, Map<String, ?> sequenceDetails);
    public ResponseEntity deleteWorkflowSequence(String workflowid, String sequenceid);

}
