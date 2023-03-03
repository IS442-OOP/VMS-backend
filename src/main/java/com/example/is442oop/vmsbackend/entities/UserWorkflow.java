package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.List;

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
    private String isApprroved;

    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY, optional = true)
    @JoinColumn(name="userID", insertable=false, updatable = false, nullable=true)
    private User user;

    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY, optional = true)
    @JoinColumn(name="workflowID", insertable=false, updatable = false, nullable=true)
    private Workflow workflow;

    @OneToMany(mappedBy="userWorkflowForAnswer", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List <Answer> answer;

    @OneToMany(mappedBy = "userWorkflow", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<UserWorkflowSequence> userWorkflowSequences;


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

    public String getIsApprroved() {
        return isApprroved;
    }

    public void setIsApprroved(String isApprroved) {
        this.isApprroved = isApprroved;
    }




    

    
}
