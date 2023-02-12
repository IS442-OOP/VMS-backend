package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="userWorkflow")
public class UserWorkflow {
    @Id 
    private Integer userWorkflowID;
    private String dateAssigned;
    private String isApprroved;

    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY, optional = true)
    @JoinColumn(name="userID", insertable=false, updatable = false, nullable=true)
    private User user;

    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY, optional = true)
    @JoinColumn(name="workflowID", insertable=false, updatable = false, nullable=true)
    private Workflow workflow;

    
    @OneToMany(mappedBy="userWorkflow", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List <Answer> answer;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUserWorkflowID() {
        return userWorkflowID;
    }

    public void setUserWorkflowID(Integer userWorkflowID) {
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
