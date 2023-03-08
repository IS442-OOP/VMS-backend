package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class UserWorkflow {
    @Id
    @SequenceGenerator(
            name = "userworkflow_sequence",
            sequenceName = "userworkflow_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userworkflow_sequence"
    )
    private Long userWorkflowID;
    private String dateAssigned;
    private String isApproved;

    @ManyToOne(cascade= CascadeType.ALL, optional = true)
    @JoinColumn(name="userID", insertable=false, updatable = false, nullable=true)
    @JsonBackReference
    private User user;

    @ManyToOne(cascade= CascadeType.ALL, optional = true)
    @JoinColumn(name="workflowID", insertable=false, updatable = false, nullable=true)
    private Workflow workflow;

    @OneToMany(mappedBy="userWorkflowForAnswer", cascade=CascadeType.ALL)
    private List <Answer> answer;

    @OneToMany(mappedBy = "userWorkflow", cascade=CascadeType.ALL)
    private List<UserWorkflowSequence> userWorkflowSequences;

    public UserWorkflow() {
    }

    public UserWorkflow(@JsonProperty("dateAssigned") String dateAssigned,
                        @JsonProperty("isApproved") String isApproved,
                        @JsonProperty("user") User user,
                        @JsonProperty("workflow") Workflow workflow) {
        this.dateAssigned = dateAssigned;
        this.isApproved = isApproved;
        this.user = user;
        this.workflow = workflow;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserWorkflowID() {
        return userWorkflowID;
    }

    public void setUserWorkflowID(Long userWorkflowID) {
        this.userWorkflowID = userWorkflowID;
    }

    public String getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(String dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }




    

    
}
