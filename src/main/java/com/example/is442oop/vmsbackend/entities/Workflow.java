package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Workflow {
    @Id
    @SequenceGenerator(
            name = "workflow_sequence",
            sequenceName = "workflow_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workflow_sequence"
    )
    private Long workflowID;
    private String name;
    @OneToMany(mappedBy="workflow", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <UserWorkflow> userWorkflow; 
    @OneToMany(mappedBy="sequence", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Sequence> sequence;

    public Workflow() {
    }

    public Workflow(Long workflowID, String name) {
        this.workflowID = workflowID;
        this.name = name;
    }

    public Long getWorkflowID() {
        return workflowID;
    }
    public void setWorkflowID(Long workflowID) {
        this.workflowID = workflowID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } 
}
