package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Workflow {
    @Id 
    private Integer workflowID;
    private String name;
    @OneToMany(mappedBy="workflow", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List <UserWorkflow> userWorkflow; 
    @OneToMany(mappedBy="sequence", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List <Sequence> sequence;

    public Workflow(Integer workflowID, String name) {
        this.workflowID = workflowID;
        this.name = name;
    }
    public Integer getWorkflowID() {
        return workflowID;
    }
    public void setWorkflowID(Integer workflowID) {
        this.workflowID = workflowID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } 
}
