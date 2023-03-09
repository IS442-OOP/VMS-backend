package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

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
    private String workflowNo;
    private String name;
    @OneToMany(mappedBy="workflow", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <UserWorkflow> userWorkflow; 
    @OneToMany(mappedBy="sequence", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Sequence> sequence;

    public Workflow() {
    }

    public Workflow(String name, String workflowNo) {
        this.name = name;
        this.workflowNo = workflowNo;
    }

    public Long getWorkflowID() {
        return workflowID;
    }
    public void setWorkflowID(Long workflowID) {
        this.workflowID = workflowID;
    }
    public String getWorkflowNo() {
        return workflowNo;
    }
    public void setWorkflowNo(String workflowNo) {
        this.workflowNo = workflowNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } 
}
