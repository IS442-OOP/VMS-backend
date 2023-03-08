package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.*;

@Entity
public class Workflow {
    @Id
//    @SequenceGenerator(
//            name = "workflow_sequence",
//            sequenceName = "workflow_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "workflow_sequence"
//    )
    private String workflowID;
    private String name;
    @OneToMany(mappedBy="workflow", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <UserWorkflow> userWorkflow; 
    @OneToMany(mappedBy="sequence", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Sequence> sequence;

    public Workflow() {
    }

    public Workflow(String workflowID, String name) {
        this.workflowID = workflowID;
        this.name = name;
    }

    public String getWorkflowID() {
        return workflowID;
    }
    public void setWorkflowID(String workflowID) {
        this.workflowID = workflowID;
    }

    public void addUserWorkflow(UserWorkflow uw) {
        userWorkflow.add(uw);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } 
}
